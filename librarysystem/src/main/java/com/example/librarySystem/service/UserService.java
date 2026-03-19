package com.example.librarySystem.service;

import com.example.librarySystem.dto.UserDto;
import com.example.librarySystem.entity.UserEntity;
import com.example.librarySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用者(User)相關 service
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 建立使用者帳號
     *
     * @param dto 從前端接收的 request 物件，包含新使用者資訊
     * @return 新增完成的使用者物件
     */
    public UserEntity createUser(UserDto dto) {

        // 防止DTO是NULL
        if (dto == null) {
            throw new IllegalArgumentException("請輸入個人資料");
        }

        if (userRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new IllegalArgumentException("電話號碼已存在");
        }

        // 驗證商品名稱是否為null或為空字串，如果是的話就會跟使用者說有錯。
        if (dto.getUsername() == null || dto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("帳號不能為空");
        }
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("密碼不能為空");
        }
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("密碼不能為空");
        }
        if (dto.getPhoneNumber() == null || dto.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("電話號碼不能為空");
        }

        // 從DTO轉換成Entity
        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return userRepository.save(entity);// 存進資料庫
    }
}
