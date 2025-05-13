package com.practice.blog.comment.controller;

import com.practice.blog.comment.dto.request.CommentRequest;
import com.practice.blog.comment.dto.request.CommentUpdateRequest;
import com.practice.blog.comment.dto.response.CommentResponse;
import com.practice.blog.comment.service.CommentService;
import com.practice.blog.comment.dto.response.PostCommentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class PostCommentController {

    private final CommentService commentService;

    // 댓글 생성
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Void> createComment(@PathVariable("postId") Long postId,
                                              @RequestBody @Valid CommentRequest request) {
        Long id = commentService.createComment(postId,request);
        return ResponseEntity.created(URI.create("/posts/"+postId+"/comments/"+id)).build();
    }

    // 댓글 목록 조회
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<PostCommentResponse> getComments(@PathVariable("postId") Long postId) {
        return ResponseEntity.ok(commentService.getPostCommentList(postId));
    }

//    // 댓글 수정
//    public ResponseEntity<CommentResponse> updateComment() {
//        return ResponseEntity.ok(response);
//    }
//
//    // 댓글 삭제
//    public ResponseEntity<Void> deleteComment() {
//        return ResponseEntity.noContent().build();
//    }
//
//    // 댓글 좋아요
//    public ResponseEntity<String> likeComment() {
//        return ResponseEntity.status(HttpStatus.CREATED).body("좋아요를 눌렀습니다.");
//    }
//
//    // 댓글 좋아요 취소
//    public ResponseEntity<String> unlikeComment() {
//        return ResponseEntity.ok("좋아요가 취소되었습니다.");
//    }
}
