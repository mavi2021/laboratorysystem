package com.cqupt.laboratorysystem.common.handler;

import cn.hutool.json.JSONUtil;
import com.cqupt.laboratorysystem.common.dto.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @create 2023/6/13 20:46
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("用户名或密码错误");
        //响应json
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        Result<Object> result = Result.fail("用户名或密码错误");
        out.print(JSONUtil.toJsonStr(result));
        out.flush();
        out.close();
    }
}