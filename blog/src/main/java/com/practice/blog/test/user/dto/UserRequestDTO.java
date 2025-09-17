package com.practice.blog.test.user.dto;

import com.practice.blog.test.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private String name;
    private String email;

    // DTO → Entity 변환
    public User toEntity() {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .build();
    }
}

