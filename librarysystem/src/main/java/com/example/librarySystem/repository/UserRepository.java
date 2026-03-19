package com.example.librarySystem.repository;


import com.example.librarySystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByPhoneNumber(String InputPhoneNumber);

    boolean existsByPhoneNumber(String phoneNumber);
}
