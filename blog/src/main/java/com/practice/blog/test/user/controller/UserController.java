package com.practice.blog.test.user.controller;

import com.practice.blog.test.user.dto.UserRequestDTO;
import com.practice.blog.test.user.entity.User;
import com.practice.blog.test.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 회원 생성
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO requestDTO) {
//
//    }

    // 회원 조회 (id)
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable Long id) {
//
//    }

    // 회원 삭제 (id)
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//
//    }
}
