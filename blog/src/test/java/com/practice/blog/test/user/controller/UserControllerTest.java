package com.practice.blog.test.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.blog.test.user.dto.UserRequestDTO;
import com.practice.blog.test.user.entity.User;
import com.practice.blog.test.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(UserController.class)
//@MockBean(JpaMetamodelMappingContext.class)
class UserControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper; // JSON 직렬화용
//
//    @MockBean
//    private UserService userService;

    // 사용자 생성
    @Test
    void make_user() throws Exception {
        // given
        String name = "김이화";
        String email = "efub@test.com";



        // userService.save() 호출 시 가짜 User 반환하도록 설정


        // when & then

    }

    // id로 사용자 조회
    @Test
    void get_user_by_id() throws Exception {
        // given

        // when & then

    }

    // 사용자 삭제
    @Test
    void delete_user() throws Exception {
        // given


        // userService.delete()는 void 반환 > 별도 반환값 설정할 필요 없음


        // when & then

    }


}

