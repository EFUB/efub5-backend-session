package com.practice.efubaccount.repository;

import com.practice.efubaccount.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Account, Long> { // 직접 DB와 소통

    // 이메일 중복검사를 위한 쿼리
    boolean existsByEmail(String email);

    // 회원 ID로 조회
    Optional<Account> findByAccountId(Long accountId); // null값을 반환해도 오류가 발생하지 않도록 optional 어노테이션 활용

}
