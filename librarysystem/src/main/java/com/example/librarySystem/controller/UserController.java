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

@RestController
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public UserEntity create(@Valid @RequestBody UserDto dto) {
        return userService.createUser(dto);
    }
}
