package com.cqupt.laboratorysystem.common.handler;

import cn.hutool.json.JSONUtil;
import com.cqupt.laboratorysystem.common.dto.Result;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @create 2023/6/13 20:15
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功");
        //响应json
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        Result<Object> result = Result.success();
        out.print(JSONUtil.toJsonStr(result));
        out.flush();
        out.close();
        response.sendRedirect("/main");
    }
}



//@Component
//public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        // Create a JSON object to hold the response data
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("success", true);
//        jsonResponse.put("message", "Login successful");
//
//        // Create a ResponseEntity object with the JSON response and the appropriate headers
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        ResponseEntity<String> responseEntity = new ResponseEntity<>(jsonResponse.toString(), headers, HttpStatus.OK);
//
//        // Write the ResponseEntity object to the response
//        response.getWriter().write(responseEntity.toString());
//        response.getWriter().flush();
//    }
//}
