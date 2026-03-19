package com.example.librarySystem.repository;


import com.example.librarySystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, String> {


    @Query("SELECT b FROM BookEntity b ORDER BY b.bookname ASC")
    List<BookEntity> findAllOrder();

    @Query("SELECT b FROM BookEntity b WHERE " +
            "LOWER(b.bookname) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.introduction) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<BookEntity> searchAllFields(@Param("keyword") String keyword);
}
