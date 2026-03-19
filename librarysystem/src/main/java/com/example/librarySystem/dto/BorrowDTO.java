package com.example.librarySystem.dto;

import com.example.librarySystem.entity.BookEntity;
import com.example.librarySystem.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BorrowDTO {
    private UserEntity user;
    private BookEntity book;
    private LocalDateTime borrowTime;
}
