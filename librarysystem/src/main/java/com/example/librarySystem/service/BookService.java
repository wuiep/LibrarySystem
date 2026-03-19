package com.example.librarySystem.service;

import com.example.librarySystem.dto.BookDto;
import com.example.librarySystem.entity.BookEntity;
import com.example.librarySystem.entity.InventoryEntity;
import com.example.librarySystem.enums.InventoryStatus;
import com.example.librarySystem.repository.BookRepository;
import com.example.librarySystem.repository.InventoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * 書籍相關 service
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InventoryRepository inventoryRepository;


    /**
     * 根據使用者輸入的關鍵字，查詢相關書籍列表
     *
     * @param keyword  使用者輸入-關鍵字
     * @param sortedBy 排列方式
     * @return 查詢條件下的書籍列表
     */
    public List<BookDto> listBooks(String keyword, String sortedBy) {
        List<BookEntity> list;

        // 如果沒有查詢關鍵字，回傳所有藏書列表；否則依照關鍵字進行查詢
        if (keyword == null || keyword.isEmpty()) {
            list = bookRepository.findAllOrder();
        } else {
            list = bookRepository.searchAllFields(keyword);
        }


        // 將查詢到的藏書列表依序轉成前端可用的格式(DTO)，並存放到 dtoList
        List<BookDto> dtoList = new ArrayList<>();
        for (BookEntity b : list) {

            BookDto dto = new BookDto();
            BeanUtils.copyProperties(b, dto);
            Optional<InventoryEntity> inventoryOpt =
                    inventoryRepository.findFirstByBookAndStatus(b, InventoryStatus.STOCK);

            if (inventoryOpt.isPresent()) {
                dto.setStatus(InventoryStatus.STOCK);
                dto.setInventoryId(inventoryOpt.get().getInventoryId());
            } else {
                dto.setStatus(InventoryStatus.LOAN); // 全部借出
                dto.setInventoryId(null);
            }

            dtoList.add(dto);
        }

        return dtoList;
    }

}
