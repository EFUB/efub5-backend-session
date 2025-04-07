package com.practice.blog.post.service;

//import com.practice.blog.account.entity.Account;
//import com.practice.blog.account.repository.AccountsRepository;
//import com.practice.blog.global.exception.BlogException;
//import com.practice.blog.global.exception.ExceptionCode;
//import com.practice.blog.post.domain.Post;
//import com.practice.blog.post.dto.summary.PostSummary;
//import com.practice.blog.post.dto.request.PostCreateRequest;
//import com.practice.blog.post.dto.request.PostUpdateRequest;
//import com.practice.blog.post.dto.response.PostResponse;
//import com.practice.blog.post.dto.response.PostListResponse;
//import com.practice.blog.post.repository.PostRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class PostService {
//
//    private final PostRepository postRepository;
//    private final AccountsRepository accountsRepository;
//
//    @Transactional
//    public Long createPost(PostCreateRequest postCreateRequest) {
//
//    }
//
//    @Transactional
//    public PostResponse getPost(Long postId) {
//
//    }
//
//    @Transactional(readOnly = true)
//    public PostListResponse getAllPosts() {
//
//    }
//
//    @Transactional
//    public void updatePostContent(Long postId, PostUpdateRequest request, Long accountId, String password) {
//
//    }
//
//    @Transactional
//    public void deletePost(Long postId, Long accountId, String password) {
//
//    }
//
//    private Post findByPostId(Long postId) {
//
//    }
//
//    private Account findByAccountId(Long accountId) {
//
//    }
//
//    private void authorizePostWriter(Post post, Account account, String password) {
//
//    }
//
//}
