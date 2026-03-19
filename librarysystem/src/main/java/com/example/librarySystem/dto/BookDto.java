package com.example.librarySystem.dto;

import com.example.librarySystem.enums.InventoryStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String ISBN;            // 書籍 ID
    private String bookname;        // 書名
    private String author;          // 作者
    private String introduction;    // 簡介
    private InventoryStatus status; // 庫存狀態 (STOCK / LOAN)
    private Long inventoryId;       // 對應借還書的 inventoryId
}
