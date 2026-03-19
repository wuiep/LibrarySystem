package com.example.librarySystem.repository;

import com.example.librarySystem.entity.BookEntity;
import com.example.librarySystem.entity.InventoryEntity;
import com.example.librarySystem.enums.InventoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 庫存相關查詢 repo
 */
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {

    // 根據該書籍查詢相關庫存資訊
    Optional<InventoryEntity> findByBook(BookEntity book);

    Optional<InventoryEntity> findFirstByBookAndStatus(BookEntity book, InventoryStatus status);
}
