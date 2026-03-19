package com.example.librarySystem.service;

import com.example.librarySystem.entity.UserEntity;
import com.example.librarySystem.repository.LoginRepository;
import com.example.librarySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private  UserRepository userRepository;
    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String phoneNumber, String password){
        if (phoneNumber == null || phoneNumber.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }//先判斷傳來的名字、密碼是否是NULL或是空值，若是就回傳false

        Optional<UserEntity> optionalUser = userRepository.findByPhoneNumber(phoneNumber);

        if (optionalUser.isPresent()) {  //檢查Optional內是否有值（是否找到對應帳號）
            UserEntity number = optionalUser.get();//如果有值，則取出Optional內的User物件
            return password.equals(number.getPassword());//比對密碼是否一致，一致則回傳true，不一致回傳false
        } else { //若沒找到一樣的帳號資料，回傳false
            return false;
        }

    }
    public UserEntity getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("找不到使用者"));
    }

}
