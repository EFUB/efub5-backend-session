package com.practice.blog.test.user.service;

import com.practice.blog.test.user.dto.UserRequestDTO;
import com.practice.blog.test.user.repository.UserRepository;
import com.practice.blog.test.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 사용자 저장
    public User save(UserRequestDTO dto) {
        return userRepository.save(dto.toEntity());
    }

    // 사용자 조회 (id)
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
    }

    // 사용자 삭제
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 사용자가 존재하지 않습니다."));
        userRepository.delete(user);
    }
}

