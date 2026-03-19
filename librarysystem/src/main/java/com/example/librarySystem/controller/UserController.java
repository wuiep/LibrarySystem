package com.example.librarySystem.controller;

import com.example.librarySystem.dto.UserDto;
import com.example.librarySystem.entity.UserEntity;
import com.example.librarySystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用者相關 controller
 */
@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 執行新增使用者作業
     *
     * @param dto 從前端接收的 request 物件，包含新使用者資訊
     * @return 建立成功的使用者物件
     */
    @PostMapping("/addUser")
    public UserEntity create(@Valid @RequestBody UserDto dto) {
        return userService.createUser(dto);
    }
}
