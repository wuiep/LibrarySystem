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

/**
 * 登入 controller
 */
@RestController
@RequestMapping("/loginController")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 執行登入作業
     *
     * @param request 從前端接收的 request 物件，包含欲登入者資訊
     * @param session 登入成功時，用於儲存當前登入使用者的資訊
     * @return 傳回登入 response 物件
     */
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
