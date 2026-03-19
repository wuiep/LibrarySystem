package com.example.librarySystem.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 登入 Response 物件
 */
@Getter
@Setter
public class LoginResponse {
    private boolean success;
    private String message;
}
