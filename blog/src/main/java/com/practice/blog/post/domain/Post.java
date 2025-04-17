package com.practice.blog.post.domain;

import com.practice.blog.account.entity.Account;
import com.practice.blog.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
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

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    // 빌더
    @Builder
    public Post(String title, String content, Account writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.viewCount = 0L;
    }

    // 조회수 증가

    // 게시물 내용 수정
    public void changeContent(String newContent) { this.content = newContent; }

}
