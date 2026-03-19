package com.example.librarySystem.repository;

import com.example.librarySystem.entity.BorrowEntity;
import com.example.librarySystem.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 借閱紀錄相關查詢 repo
 */
public interface BorrowRepository extends JpaRepository<BorrowEntity, Long> {

    // 查詢該庫存是否存在未歸還的借閱紀錄
    boolean existsByInventoryAndReturnTimeIsNull(InventoryEntity inventory);

    // 查詢該庫存的未歸還借閱紀錄
    Optional<BorrowEntity> findByInventoryAndReturnTimeIsNull(InventoryEntity inventory);
}
