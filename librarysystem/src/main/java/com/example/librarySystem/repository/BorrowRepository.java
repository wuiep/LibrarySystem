package com.example.librarySystem.repository;

import com.example.librarySystem.entity.BookEntity;
import com.example.librarySystem.entity.BorrowEntity;
import com.example.librarySystem.entity.InventoryEntity;
import com.example.librarySystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowRepository extends JpaRepository<BorrowEntity,Long> {
    boolean existsByInventoryAndReturnTimeIsNull(InventoryEntity inventory);

    Optional<BorrowEntity> findByInventoryAndReturnTimeIsNull(InventoryEntity inventory);
}
