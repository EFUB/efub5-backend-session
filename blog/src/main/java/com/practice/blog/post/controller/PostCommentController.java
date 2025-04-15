package com.practice.blog.post.controller;

import com.practice.blog.comment.dto.request.CommentRequest;
import com.practice.blog.comment.service.CommentService;
//import com.practice.blog.post.dto.response.PostCommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/comments")
public class PostCommentController {

    private final CommentService commentService;

    //댓글 생성
    @PostMapping
    public ResponseEntity<Void> createComment(@PathVariable("postId") Long postId, @RequestBody CommentRequest commentRequest) {
        Long id = commentService.createComment(postId, commentRequest);
        return ResponseEntity.created(URI.create("/posts/" + postId + "/comments/" + id)).build();
    }

    //게시물별 댓글 목록 조회
}
