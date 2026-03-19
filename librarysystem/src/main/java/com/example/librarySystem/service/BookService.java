package com.example.librarySystem.service;


import com.example.librarySystem.dto.BookDTO;
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

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<BookDTO> listBooks(String keyword, String sortedBy) {

        List<BookEntity> list;

        if (keyword == null || keyword.isEmpty()) {
            list = bookRepository.findAllOrder();
        } else {
            list = bookRepository.searchAllFields(keyword);
        }

        List<BookDTO> dtoList = new ArrayList<>();

        for (BookEntity b : list) {

            BookDTO dto = new BookDTO();
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
