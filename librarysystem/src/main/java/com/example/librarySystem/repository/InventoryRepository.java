package com.example.librarySystem.repository;

import com.example.librarySystem.entity.BookEntity;
import com.example.librarySystem.entity.InventoryEntity;
import com.example.librarySystem.enums.InventoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {
    Optional<InventoryEntity> findByBook(BookEntity book);

    Optional<InventoryEntity> findFirstByBookAndStatus(BookEntity book, InventoryStatus status);
}
