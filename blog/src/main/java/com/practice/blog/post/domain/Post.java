package com.practice.blog.post.domain;

import com.practice.blog.account.entity.Account;
import com.practice.blog.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {  //상속받아서 자동으로 생성/수정일시 저장

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제목
    private String title;

    // 내용
    private String content;

    // 글쓴이
    @ManyToOne(fetch = FetchType.LAZY)
    private Account writer;

    // 조회수
    private Long viewCount;

    // 빌더
    @Builder
    public Post(String title, String content, Account writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.viewCount = 0L;
    }

    // 조회수 증가

    // 게시물 내용 수정
    public void changeContent(String newContent){
        this.content = newContent;
    }

}
