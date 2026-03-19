package com.example.librarySystem.repository;

import com.example.librarySystem.entity.BookEntity;
import com.example.librarySystem.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {
    Optional<InventoryEntity> findByBook(BookEntity book);
}
