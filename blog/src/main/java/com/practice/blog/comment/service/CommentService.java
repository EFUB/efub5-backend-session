//package com.practice.blog.comment.service;
//
//import com.practice.blog.account.dto.response.AccountCommentResponse;
//import com.practice.blog.account.entity.Account;
//import com.practice.blog.account.repository.AccountsRepository;
//import com.practice.blog.comment.domain.Comment;
//import com.practice.blog.comment.dto.request.CommentRequest;
//import com.practice.blog.comment.repository.CommentRepository;
//import com.practice.blog.global.exception.BlogException;
//import com.practice.blog.global.exception.ExceptionCode;
//import com.practice.blog.post.domain.Post;
//import com.practice.blog.post.dto.response.PostCommentResponse;
//import com.practice.blog.post.repository.PostRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class CommentService {
//
//    private final AccountsRepository accountsRepository;
//    private final PostRepository postRepository;
//    private final CommentRepository commentRepository;
//
//    //댓글 생성
//
//    //postId로 댓글 목록 조회
//
//    //accountId로 댓글 목록 조회
//
//    private Post findByPostId(Long postId) {
//        return postRepository.findById(postId)
//                .orElseThrow(()-> new BlogException(ExceptionCode.POST_NOT_FOUND));
//    }
//
//    private Account findByAccountId(Long accountId) {
//        return accountsRepository.findByAccountId(accountId)
//                .orElseThrow(()-> new BlogException(ExceptionCode.ACCOUNT_NOT_FOUND));
//    }
//}
