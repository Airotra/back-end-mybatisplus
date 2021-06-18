package com.example.mybatisplus.web.controller;


import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.common.utls.SecurityUtils;
import com.example.mybatisplus.model.dto.UserInfoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @GetMapping("/userInfo")
    public JsonResponse<UserInfoDTO> getUserInfo(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return JsonResponse.success(SecurityUtils.getUserInfo());
    }
}
