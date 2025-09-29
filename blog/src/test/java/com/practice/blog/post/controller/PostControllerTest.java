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

class PostControllerTest {



    @Test
    @DisplayName("GET /posts/{id} → 서비스가 정확한 id(7)를 받음")
    void getPost_callsServiceWithRightId() throws Exception {
        // given


        // when


        // then

    }


    @Test
    @DisplayName("POST /posts → 201 & Location 헤더")
    void createPost_201_Location() throws Exception {
        // given


        // when then

    }

    @Test
    @DisplayName("GET /posts/{id} → 200 & title 확인")
    void getPost_200_title() throws Exception {
        // given

        // when then
        
    }
}