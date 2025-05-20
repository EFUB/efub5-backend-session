package com.practice.blog.follow.domain;

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
public class Follow extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private Long followId;

    //팔로워
    @ManyToOne(fetch = FetchType.LAZY) // 디폴트가 즉시니까 지연로딩으로
    @JoinColumn(name = "follower_id")
    private Account follower;

    //팔로잉
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_id")
    private Account following;

    //빌더
    @Builder
    public Follow(Account follower, Account following) {
        this.follower = follower;
        this.following = following;
    }
}
