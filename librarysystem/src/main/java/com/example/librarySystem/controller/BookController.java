package com.example.librarySystem.controller;

import com.example.librarySystem.dto.BookDTO;
import com.example.librarySystem.dto.BorrowDTO;
import com.example.librarySystem.dto.BorrowResponse;
import com.example.librarySystem.entity.UserEntity;
import com.example.librarySystem.service.BookService;
import com.example.librarySystem.service.BorrowService;
import com.example.librarySystem.service.ReturnService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private ReturnService returnService;

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public ResponseEntity<List<BookDTO>> listBooks(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String sortedBy) {

        List<BookDTO> books = bookService.listBooks(keyword, sortedBy);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/borrow")
    public ResponseEntity<?> borrowBook(@RequestBody Map<String, Long> body, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("請先登入才能借書");
        }

        Long inventoryId = body.get("inventoryId");

        try {
            BorrowDTO response = borrowService.addRecord(user.getUserId(), inventoryId);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnBook(@RequestBody Map<String, Long> body, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("請先登入才能還書");
        }

        Long inventoryId = body.get("inventoryId");

        try {
            returnService.returnBook(user.getUserId(), inventoryId); // Service 回傳 void
            return ResponseEntity.ok("還書成功");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
