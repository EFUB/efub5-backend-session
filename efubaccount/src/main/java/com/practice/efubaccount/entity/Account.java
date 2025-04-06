package com.practice.efubaccount.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "accounts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    // 회원 이메일 - 중복되지 않음.
    @Column(unique = true)
    private String email;

    // 회원 비밀번호
    @Column(nullable = false)
    private String password;

    // 회원 닉네임 - 수정 불가
    @Column(nullable = false, updatable = false)
    private String nickname;

    // 회원 자기소개(bio), default 값은 "안녕하세요!"
    @Column(nullable = false)
    private String bio = "안녕하세요!";

    // 회원 상태
    @Enumerated
    @Column
    private AccountStatus status = AccountStatus.ACTIVE;

    @Builder
    public Account(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public void updateBio(String bio) {
        this.bio = bio;
    }

    public void changeStatus(AccountStatus status) {
        this.status = status;
    }
}
