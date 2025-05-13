package com.practice.blog.post.dto.request;

import com.practice.blog.account.entity.Account;
import com.practice.blog.post.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//record : 데이터만 포함하는 불변한 객체를 정의하는 데이터 클래스
public record PostCreateRequest(@NotNull Long accountId,// 계정 아이디
                                @NotBlank String title,// 제목 (빈 내용 x)
                                @Size(min=5, max=500) String content// 내용 (5자 ~ 500자)
                                ) {
    public Post toEntity(Account account){
        return Post.builder()
                .title(title)
                .content(content)
                .writer(account)
                .build();
    }

}
