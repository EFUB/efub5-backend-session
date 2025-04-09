package com.practice.blog.post.controller;

import com.practice.blog.post.dto.request.PostCreateRequest;
import com.practice.blog.post.dto.request.PostUpdateRequest;
import com.practice.blog.post.dto.response.PostListResponse;
import com.practice.blog.post.dto.response.PostResponse;
import com.practice.blog.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    // 게시물 생성
    @PostMapping
    public ResponseEntity<Void> createPost(@Valid @RequestBody PostCreateRequest postCreateRequest){
        Long postId = postService.createPost(postCreateRequest);
        return ResponseEntity.created(URI.create("/posts/" + postId)).build();
        //location 헤더에 만든 uri를 넣어줌. 프론트가 편함!
    }

    // 게시물 목록 조회
    @GetMapping
    public ResponseEntity<PostListResponse> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // 게시물 내용 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("id") Long postId){
        return ResponseEntity.ok(postService.getPost(postId));
    }

    // 게시물 내용 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePostContent(@PathVariable("id") Long postId,
                                                  //jwt 토큰에 들어있을 id, 비밀번호
                                                  @RequestHeader("Auth-Id") Long accountId,
                                                  @RequestHeader("Auth-Password") String password,
                                                  @Valid @RequestBody PostUpdateRequest postUpdateRequest){
        postService.updatePostContent(postId, postUpdateRequest, accountId, password);
        return ResponseEntity.noContent().build();
    }

    // 게시물 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long postId,
                                           @RequestHeader("Auth-Id") Long accountId,
                                           @RequestHeader("Auth-Password") String password){
        postService.deletePost(postId, accountId, password);
        return ResponseEntity.noContent().build();
    }
}
