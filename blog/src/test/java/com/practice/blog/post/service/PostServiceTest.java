package com.practice.blog.post.service;

import com.practice.blog.account.entity.Account;
import com.practice.blog.account.service.AccountService;
import com.practice.blog.post.domain.Post;
import com.practice.blog.post.dto.response.PostResponse;
import com.practice.blog.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Test
    void PostService_생성_성공(@Mock AccountService accountService, @Mock PostRepository postRepository) {
        Account account = new Account("efub@example.com", "password", "efub");
        account.setAccountId(1L);

        when(accountService.findByAccountId(1L)).thenReturn(account);

        PostService postService = new PostService(postRepository, accountService);

        Account foundAccount = accountService.findByAccountId(1L);

        assertEquals(1L, foundAccount.getAccountId());
    }

    @Test
    void createPost_작성자조회성공_정상생성(@Mock AccountService accountService, @Mock PostRepository postRepository) {
        //given
        Account account = new Account("efub@example.com", "password", "efub");
        account.setAccountId(1L);

        when(accountService.findByAccountId(1L)).thenReturn(account);

        //when
        Account found = accountService.findByAccountId(1L);

        //then
        assertEquals(1L, found.getAccountId());
    }

    @Test
    void deletePost_wnd_postRepository_delete에서_예외_전달(@Mock AccountService accountService, @Mock PostRepository postRepository) {
        Account account = new Account("efub@example.com", "testpw", "efub");
        account.setAccountId(1L);

        Post post = new Post("제목", "내용", account);
        post.setId(10L);

        when(postRepository.findById(10L)).thenReturn(Optional.of(post));
        when(accountService.findByAccountId(1L)).thenReturn(account);

        doThrow(new IllegalArgumentException("삭제 실패"))
                .when(postRepository).delete(any(Post.class));

        PostService postService = new PostService(postRepository, accountService);

        assertThrows(IllegalArgumentException.class,
                () -> postService.deletePost(10L, 1L, "testpw"));
    }

    @Test
    void findAccountId_2번째호출에서_오류(@Mock AccountService accountService, @Mock PostRepository postRepository) {
        Account a1 = new Account("efub1@example.com", "testpw1", "efub1");
        a1.setAccountId(1L); // a1의 ID 설정
        Account a2 = new Account("efub2@example.com", "testpw2", "efub2");
        a2.setAccountId(2L); // a2의 ID 설정

        when(accountService.findByAccountId(any()))
                .thenReturn(a1) // 첫번째호출
                .thenThrow(new RuntimeException("두번째실패"))
                .thenReturn(a2); // 세번째호출

        PostService postService = new PostService(postRepository, accountService);

        // 첫 호출 : a1 반환
        Account first = accountService.findByAccountId(111L);
        assertEquals(1L, first.getAccountId());

        // 두번째 호출 : 예외 발생
        assertThrows(RuntimeException.class,
                ()->accountService.findByAccountId(222L));

        // 세번째 호출 : a2 반환
        Account third = accountService.findByAccountId(333L);
        assertEquals(2L, third.getAccountId());
    }

    @Test
    void getPost_조회수증가_호출검증(@Mock AccountService accountService, @Mock PostRepository postRepository) {
        Account writer = new Account("efub@example.com", "password", "efub");
        Post post = new Post("제목", "내용", writer);
        post.setId(5L);

        when(postRepository.findById(5L)).thenReturn(Optional.of(post));

        PostService postService = new PostService(postRepository, accountService);

        PostResponse res = postService.getPost(5L);

        assertNotNull(res);
        verify(postRepository).increaseViewCount(5L);
        verify(postRepository, times(1)).findById(5L);
        verifyNoMoreInteractions(postRepository);
    }
}