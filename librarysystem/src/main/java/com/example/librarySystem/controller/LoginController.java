package com.example.librarySystem.controller;


import com.example.librarySystem.dto.LoginResponse;
import com.example.librarySystem.dto.UserDto;
import com.example.librarySystem.entity.UserEntity;
import com.example.librarySystem.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginController")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UserDto request, HttpSession session) {
        LoginResponse response = new LoginResponse();

        boolean isAuthenticated = loginService.authenticate(request.getPhoneNumber(), request.getPassword());
        response.setSuccess(isAuthenticated);
        response.setMessage(isAuthenticated ? "登入成功" : "帳號或密碼有誤");

        if (isAuthenticated) {
            //取得使用者完整資訊
            UserEntity user = loginService.getUserByPhoneNumber(request.getPhoneNumber());
            //存到session
            session.setAttribute("user", user);
        }

        return response;
    }

}
