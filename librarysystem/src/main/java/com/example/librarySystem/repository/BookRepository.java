package com.example.librarySystem.repository;

import com.example.librarySystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 書籍相關查詢 repo
 */
public interface BookRepository extends JpaRepository<BookEntity, String> {

    // 查詢所有藏書列表，並依照書名正序排序
    @Query("SELECT b FROM BookEntity b ORDER BY b.bookname ASC")
    List<BookEntity> findAllOrder();

    // 依照關鍵字查詢藏書列表
    @Query("SELECT b FROM BookEntity b WHERE " +
            "LOWER(b.bookname) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.introduction) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<BookEntity> searchAllFields(@Param("keyword") String keyword);
}
