package com.example.librarySystem.service;


import com.example.librarySystem.dto.BookDTO;
import com.example.librarySystem.entity.BookEntity;
import com.example.librarySystem.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;


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
            dtoList.add(dto);
        }

        return dtoList;
    }

}
