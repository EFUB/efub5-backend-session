package com.practice.efubaccount.dto;

import com.practice.efubaccount.entity.Account;
import lombok.Builder;
import lombok.Getter;

// Account 생성 후 응답 DTO

@Builder
@Getter
public class CreateAccountResponseDto {
    private Long id;
    private String nickname;
    private String email;
    private String bio;

    public static CreateAccountResponseDto from(Account account) {
        return CreateAccountResponseDto.builder()
                .id(account.getAccountId())
                .nickname(account.getNickname())
                .email(account.getEmail())
                .bio(account.getBio())
                .build();
    } // 어카운트 객체로 받아서 DTO 객체 형태로 전환할 때 쓰는? from 메소드
}