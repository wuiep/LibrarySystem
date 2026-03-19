package com.example.librarySystem.service;

import com.example.librarySystem.entity.UserEntity;
import com.example.librarySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 登入功能相關 service
 */
@Service
public class LoginService {

    @Autowired
    private  UserRepository userRepository;

    /**
     * 登入驗證
     *
     * @param phoneNumber 使用者輸入-手機號碼
     * @param password    使用者輸入-密碼
     * @return 是否驗證成功
     */
    public boolean authenticate(String phoneNumber, String password) {

        // 先判斷傳來的名字、密碼是否是NULL或是空值，若是就回傳false
        if (phoneNumber == null || phoneNumber.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        Optional<UserEntity> optionalUser = userRepository.findByPhoneNumber(phoneNumber);

        // 檢查Optional內是否有值（是否找到對應帳號）
        if (optionalUser.isPresent()) {
            // 如果有值，則取出Optional內的User物件
            UserEntity number = optionalUser.get();
            // 比對密碼是否一致，一致則回傳true，不一致回傳false
            return password.equals(number.getPassword());
        } else {
            // 若沒找到一樣的帳號資料，回傳false
            return false;
        }

    }

    /**
     * 根據手機號碼查詢所屬使用者
     *
     * @param phoneNumber 欲查詢的手機號碼
     * @return 查詢條件下所找到的使用者物件
     */
    public UserEntity getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("找不到使用者"));
    }

}
