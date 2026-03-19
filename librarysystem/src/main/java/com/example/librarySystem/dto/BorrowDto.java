package com.example.librarySystem.dto;

import com.example.librarySystem.entity.BookEntity;
import com.example.librarySystem.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 借閱紀錄物件 DTO
 */
@Getter
@Setter
public class BorrowDto {
    private UserEntity user;
    private BookEntity book;
    private LocalDateTime borrowTime;
}
