package com.example.librarySystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 使用者物件 DTO
 */
@Getter
@Setter
public class UserDto {

    private Long userId;

    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String username;

    @Size(min = 8, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String password;

    @Size(min = 8, max = 10)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String phoneNumber;

    @Size(min = 6, max = 30)
    @NotBlank(message = "Email不能為空")
    @Email(message = "必須是有效的Email格式")
    private String email;

}
