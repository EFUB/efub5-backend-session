package com.practice.blog.test.user.service;

import com.practice.blog.test.user.dto.UserRequestDTO;
import com.practice.blog.test.user.entity.Role;
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
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        return userRepository.save(dto.toEntity());
    }

    // 사용자 조회 (id)
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
    }

    // 삭제 (관리자만 가능)
    public void delete(Long id, User requester) {
        if (requester.getRole() != Role.ADMIN) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
        userRepository.deleteById(id);
    }

}

