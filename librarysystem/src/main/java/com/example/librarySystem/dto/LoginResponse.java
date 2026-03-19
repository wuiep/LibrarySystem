package com.example.librarySystem.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoginResponse {
    private boolean success;
    private String message;
}
