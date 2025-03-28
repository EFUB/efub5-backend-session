package com.practice.efubaccount.dto;

import com.practice.efubaccount.entity.Account;
import lombok.Getter;

// 계정 생성 Request DTO
@Getter
public class CreateAccountRequestDto {

    private String email;

    private String password;

    private String nickname;

    // Account 객체로 build
    public Account toEntity() {
        return Account.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .build();
    }
}