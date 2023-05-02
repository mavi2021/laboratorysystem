package com.cqupt.laboratorysystem.controller;

import com.cqupt.laboratorysystem.annotation.Limit;
import com.cqupt.laboratorysystem.dto.Result;
import com.cqupt.laboratorysystem.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2023/5/2 21:32
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/sendCode")
    public Result sendCode(){
        return loginService.sendCode();

    }
}
