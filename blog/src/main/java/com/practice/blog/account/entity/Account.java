package com.practice.blog.account.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    // 회원 이메일
    @Email
    @Column(unique = true)
    private String email;

    // 회원 비밀번호
    @Column(nullable = false)
    private String password;

    // 회원 닉네임
    @Column(nullable = false, updatable = false)
    private String nickname;

    // 회원 자기소개, default 값은 "안녕하세요!"
    @Column
    private String bio="안녕하세요!";

    // 회원 상태
    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.ACTIVE;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

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
