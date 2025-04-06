package com.practice.efubaccount.repository;

import com.practice.efubaccount.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Account, Long> { // jpa 레포지토리 상속받기

    // 이메일 중복검사를 위한 쿼리
    boolean existsByEmail(String email);

    // 회원 ID로 조회
    Optional<Account> findByAccountId(Long accountId); // 옵셔널로 매핑해서, id가 없어 null값을 반환하는 경우도 안전하게 !

}
