package com.practice.blog.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.blog.BlogApplication;
import com.practice.blog.post.dto.response.PostResponse;
import com.practice.blog.post.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "/data.sql")
@ActiveProfiles("test")
@ContextConfiguration(classes = BlogApplication.class)
@TestPropertySource(locations = "classpath:application-test.yml")
class PostControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @MockBean PostService postService;

    @Test
    @DisplayName("GET /posts/{id} → 서비스가 정확한 id(7)를 받음")
    void getPost_callsServiceWithRightId() throws Exception {
        // given
        PostResponse dto = new PostResponse(1L, 1L, "닉네임", "제목", null, null, null, 10L);
        when(postService.getPost(anyLong())).thenReturn(dto); // 어떤 id든 DTO 반환

        // when
        mockMvc.perform(get("/posts/{id}", 1L))
                .andExpect(status().isOk());

        // then
        verify(postService, times(1)).getPost(1L);
    }


    @Test
    @DisplayName("POST /posts → 201 & Location 헤더")
    void createPost_201_Location() throws Exception {
        // given
        when(postService.createPost(any())).thenReturn(123L);

        String body = """
          {"title":"제목","content":"내용은다섯글자이상","accountId":1}
        """;

        // when then
        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/posts/123"));
    }

    @Test
    @DisplayName("GET /posts/{id} → 200 & title 확인")
    void getPost_200_title() throws Exception {
        // given
        PostResponse dto = new PostResponse(
                1L, 2L, "닉네임", "제목", null, null, null, 0L);
        when(postService.getPost(1L)).thenReturn(dto);

        // when then
        mockMvc.perform(get("/posts/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("제목"));
    }
}