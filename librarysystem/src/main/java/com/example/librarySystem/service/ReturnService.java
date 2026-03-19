package com.example.librarySystem.service;

import com.example.librarySystem.entity.BookEntity;
import com.example.librarySystem.entity.BorrowEntity;
import com.example.librarySystem.entity.InventoryEntity;
import com.example.librarySystem.entity.UserEntity;
import com.example.librarySystem.enums.InventoryStatus;
import com.example.librarySystem.repository.BookRepository;
import com.example.librarySystem.repository.BorrowRepository;
import com.example.librarySystem.repository.InventoryRepository;
import com.example.librarySystem.repository.LoginRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReturnService {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Transactional
    public void returnBook(Long userId, Long inventoryId) {

        if (userId == null) {
            throw new IllegalArgumentException("userId 不能為空");
        }

        if (inventoryId == null) {
            throw new IllegalArgumentException("inventoryId 不能為空");
        }

        // 找使用者
        UserEntity user = loginRepository.findById(userId)
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

        inventory.setStatus(InventoryStatus.STOCK);

        // 存回資料庫
        borrowRepository.save(record);
        inventoryRepository.save(inventory);
    }
}
