package com.example.librarySystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private String ISBN;
    String bookname;
    String author;
    String introduction;
}
