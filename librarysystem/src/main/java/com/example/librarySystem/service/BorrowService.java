package com.example.librarySystem.service;

import com.example.librarySystem.dto.BorrowDTO;
import com.example.librarySystem.entity.BorrowEntity;
import com.example.librarySystem.entity.InventoryEntity;
import com.example.librarySystem.entity.UserEntity;
import com.example.librarySystem.enums.InventoryStatus;
import com.example.librarySystem.repository.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class BorrowService {
    //注入要用到的Repository介面

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional //確保下單的整個流程在同一個事件，若某一步有出錯，就會全部回溯，不會產生半筆訂單
    public BorrowDTO addRecord(Long userId, Long inventoryId) {

        //驗證每個欄位不能為null或不合法，找不到會拋出例外
        if (userId == null) {
            throw new IllegalArgumentException("userId 不能為空");
        }
        if (inventoryId == null) {
            throw new IllegalArgumentException("inventoryId 不能為空");
        }

        //資料查詢商品ID跟使用者ID，找不到會拋出例外
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("找不到指定的使用者"));

        InventoryEntity inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("找不到書籍"));

        if (inventory.getStatus() != InventoryStatus.STOCK) {
            throw new RuntimeException("此書不可借");
        }

        // 檢查是否已借出
        if (borrowRepository.existsByInventoryAndReturnTimeIsNull(inventory)) {
            throw new RuntimeException("此書已被借出");
        }

        //建立訂單Entity，將前端資料對應到資料庫欄位
        BorrowEntity record = new BorrowEntity();
        record.setUser(user);
        record.setInventory(inventory);
        record.setBorrowTime(LocalDateTime.now());

        inventory.setStatus(InventoryStatus.LOAN);
        inventoryRepository.save(inventory);


        record = borrowRepository.save(record);

        //把資料庫的訂單資料先轉成前端可用的格式(DTO)
        BorrowDTO response = new BorrowDTO();
        response.setUser(record.getUser());
        response.setBook(record.getInventory().getBook());
        response.setBorrowTime(record.getBorrowTime());
        return response;//回傳完整訂單資料給前端
    }

}
