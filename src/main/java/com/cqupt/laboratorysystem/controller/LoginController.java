package com.cqupt.laboratorysystem.controller;

import com.cqupt.laboratorysystem.annotation.Limit;
import com.cqupt.laboratorysystem.dto.Result;
import com.cqupt.laboratorysystem.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2023/5/2 21:32
 */
@Slf4j
@RestController
@RequestMapping("/login")
@Api(tags = "登录管理功能接口")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/sendCode")
    @Limit(period = 60, requestLimitMaxNum = 100, type = "ip")
    @ApiOperation(value = "发送验证码")
    public Result sendCode(){
        return loginService.sendCode();
    }

    @PreAuthorize(value = "")
    @GetMapping("/login")
    public <T>Result login(Class<T>user){
        return loginService.login(user);
    }
}
