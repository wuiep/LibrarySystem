package com.example.librarySystem.service;

import com.example.librarySystem.entity.BorrowEntity;
import com.example.librarySystem.entity.InventoryEntity;
import com.example.librarySystem.entity.UserEntity;
import com.example.librarySystem.enums.InventoryStatus;
import com.example.librarySystem.repository.*;
import com.example.librarySystem.repository.BorrowRepository;
import com.example.librarySystem.repository.InventoryRepository;
import com.example.librarySystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 歸還功能相關 service
 */
@Service
public class ReturnService {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    /**
     * 歸還書籍
     *
     * @param userId      借閱者
     * @param inventoryId 書籍編號
     */
    @Transactional
    public void returnBook(Long userId, Long inventoryId) {

        if (userId == null) {
            throw new IllegalArgumentException("userId 不能為空");
        }

        if (inventoryId == null) {
            throw new IllegalArgumentException("inventoryId 不能為空");
        }

        // 找使用者
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("找不到使用者"));

        // 找書
        InventoryEntity inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("找不到書籍"));

        // 找借閱紀錄（還沒還的）
        BorrowEntity record = borrowRepository
                .findByInventoryAndReturnTimeIsNull(inventory)
                .orElseThrow(() -> new RuntimeException("沒有未歸還的紀錄"));

        // 設定歸還時間
        record.setReturnTime(LocalDateTime.now());

        // 設定藏書狀態
        inventory.setStatus(InventoryStatus.STOCK);

        // 存回資料庫
        borrowRepository.save(record);
        inventoryRepository.save(inventory);
    }
}
