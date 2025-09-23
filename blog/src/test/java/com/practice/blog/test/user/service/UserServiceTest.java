package com.practice.blog.test.user.service;

import com.practice.blog.test.user.dto.UserRequestDTO;
import com.practice.blog.test.user.entity.User;
import com.practice.blog.test.user.entity.Role;
import com.practice.blog.test.user.repository.UserRepository;
import com.practice.blog.test.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;


import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private Validator validator;
    private User testUser;

    @BeforeEach
    void setUp() {

    }

    // 중복 이메일 방지





    // 권한 검사





    // 입력 유효성 검증 (이메일 형식)






    // 정상 조회




}
