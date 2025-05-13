package com.practice.blog.comment.domain;

import com.practice.blog.account.entity.Account;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLike {
    //댓글 좋아요(commentLike)는 댓글과 사용자 모두와
    //연결되어있으므로, comment엔티티 내부에 포함시키기보다
    //commentLike를 분리하는 것이 성능과 유지보수에 적합

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="comment_id", updatable = false,nullable = false)
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id", updatable = false, nullable = false)
    private Account account;

    @Builder
    public CommentLike(Comment comment, Account account){
        this.comment=comment;
        this.account=account;
    }


}
