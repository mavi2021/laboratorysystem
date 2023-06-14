package com.cqupt.laboratorysystem.controller;

import com.cqupt.laboratorysystem.common.annotation.Limit;
import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.service.LoginService;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @create 2023/5/2 21:32
 */
@Slf4j
@Controller
//@RestController
//@RequestMapping("/login")
@Api(tags = "登录管理功能接口")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;



    @PostMapping("/login/sendCode")
    @Limit(period = 60, requestLimitMaxNum = 100, type = "ip")
    @ApiOperation(value = "发送验证码")
    public Result sendCode(){
        return loginService.sendCode();
    }

//    @PostMapping
//    public String login(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication.getName());
////        return "/main2.html";
//        return "redirect:/index";
//    }

//    @GetMapping
//    public String getLogin(){
//        return "login";
//    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "heihei";
    }
}
