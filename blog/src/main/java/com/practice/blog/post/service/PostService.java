package com.practice.blog.post.service;

import com.practice.blog.account.entity.Account;
import com.practice.blog.account.repository.AccountsRepository;
import com.practice.blog.global.exception.BlogException;
import com.practice.blog.global.exception.ExceptionCode;
import com.practice.blog.post.domain.Post;
import com.practice.blog.post.dto.request.PostCreateRequest;
import com.practice.blog.post.dto.request.PostUpdateRequest;
import com.practice.blog.post.dto.response.PostListResponse;
import com.practice.blog.post.dto.response.PostResponse;
import com.practice.blog.post.dto.summary.PostSummary;
import com.practice.blog.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AccountsRepository accountsRepository;

    @Transactional
    public Long createPost(PostCreateRequest postCreateRequest) {
        Long accountId = postCreateRequest.accountId();
        Account writer = findByAccountId(accountId);
        Post newPost = postCreateRequest.toEntity(writer);
        postRepository.save(newPost);
        return newPost.getId();
    }

    @Transactional
    public PostResponse getPost(Long postId) {
        //게시물 조회 시 조회수 상승
        postRepository.increaseViewCount(postId);
        Post post = findByPostId(postId);
        return PostResponse.from(post);
    }

    @Transactional(readOnly = true)
    public PostListResponse getAllPosts() {
        List<PostSummary> postSummaries = postRepository.findByOrderByCreatedAtDesc()
                .stream()
                .map(PostSummary::from).toList();   //PostSummary 함수의 from 사용
        return new PostListResponse(postSummaries, postRepository.count());
    }

    @Transactional
    public void updatePostContent(Long postId, PostUpdateRequest request, Long accountId, String password) {
        Post post = findByPostId(postId);
        //accountId와 password로 작성자가 맞는지 확인.
        Account account = findByAccountId(accountId);
        authorizePostWriter(post, account, password);

        post.changeContent(request.content());
    }

    @Transactional
    public void deletePost(Long postId, Long accountId, String password) {
        Post post = findByPostId(postId);
        //accountId와 password로 작성자가 맞는지 확인.
        Account account = findByAccountId(accountId);
        authorizePostWriter(post, account, password);
        postRepository.delete(post);
    }

    private Post findByPostId(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new BlogException(ExceptionCode.POST_NOT_FOUND));
    }

    private Account findByAccountId(Long accountId) {
        return accountsRepository.findByAccountId(accountId)
                .orElseThrow(() -> new BlogException(ExceptionCode.ACCOUNT_NOT_FOUND));
    }

    private void authorizePostWriter(Post post, Account account, String password) {
        if(!post.getWriter().equals(account) || !post.getWriter().getPassword().equals(password)){
            throw new BlogException(ExceptionCode.POST_ACCOUNT_MISMATCH);
        }
    }
}
