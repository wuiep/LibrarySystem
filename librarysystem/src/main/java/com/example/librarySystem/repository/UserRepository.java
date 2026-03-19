package com.example.librarySystem.repository;

import com.example.librarySystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 使用者相關查詢 repo
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // 根據手機號碼查詢所屬使用者
    Optional<UserEntity> findByPhoneNumber(String InputPhoneNumber);

    // 查詢該手機號碼是否已存被使用
    boolean existsByPhoneNumber(String phoneNumber);
}
