package com.example.librarySystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowResponse {
    private Long userId;
    private Long inventoryId;
}
