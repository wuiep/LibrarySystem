package com.example.librarySystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@Table(name = "book")
public class BookEntity {

    @Id
    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "name",nullable = false)
    String bookname;

    @Column(name = "author",nullable = false)
    String author;

    @Column(name = "introduction",nullable = false)
    String introduction;

}
