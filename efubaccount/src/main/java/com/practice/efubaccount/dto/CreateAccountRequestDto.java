package com.practice.efubaccount.dto;

import com.practice.efubaccount.entity.Account;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 계정 생성 Request DTO
@Getter
@NoArgsConstructor
public class CreateAccountRequestDto { // 모든 값이 아닌 필요한 값들만 갖고 객체를 생성하기 위해 DTO 사용

    @NotBlank // validation
    private String email;

    @NotBlank
    private String password;

    @NotBlank
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