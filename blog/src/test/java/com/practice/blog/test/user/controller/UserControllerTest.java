package com.practice.blog.test.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.blog.test.user.dto.UserRequestDTO;
import com.practice.blog.test.user.entity.User;
import com.practice.blog.test.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@MockBean(JpaMetamodelMappingContext.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // JSON 직렬화용

    @MockBean
    private UserService userService;

    // 사용자 생성
    @Test
    void 사용자_생성() throws Exception {
        // given
        String name = "김이화";
        String email = "efub@test.com";

        UserRequestDTO requestDTO = UserRequestDTO.builder()
                .name(name)
                .email(email)
                .build();

        String requestBody = objectMapper.writeValueAsString(requestDTO);

        // userService.save() 호출 시 가짜 User 반환하도록 설정
        given(userService.save(any(UserRequestDTO.class)))
                .willReturn(User.builder()
                        .id(1L)
                        .name(name)
                        .email(email)
                        .build());

        // when & then
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.email").value(email));
    }

    // id로 사용자 조회
    @Test
    void id로_사용자_조회() throws Exception {
        // given
        Long userId = 1L;
        String name = "김이화";
        String email = "efub@test.com";

        User mockUser = User.builder()
                .id(userId)
                .name(name)
                .email(email)
                .build();

        given(userService.findById(userId)).willReturn(mockUser);

        // when & then
        mockMvc.perform(get("/users/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.email").value(email));
    }

    // 사용자 삭제 - 일반 유저 권한
    @Test
    void 일반유저가_삭제하면_권한없음_예외() throws Exception {
        // given
        Long userId = 1L;
        willThrow(new IllegalArgumentException("권한이 없습니다."))
                .given(userService).delete(eq(userId), any(User.class));

        // when & then
        mockMvc.perform(delete("/users/{id}", userId)
                        .param("role", "USER"))   // 요청자가 USER
                .andExpect(status().isBadRequest()); // 400 반환 기대
    }


}

