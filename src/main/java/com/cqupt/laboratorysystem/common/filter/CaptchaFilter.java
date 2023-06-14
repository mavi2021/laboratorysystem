package com.cqupt.laboratorysystem.common.filter;

import cn.hutool.json.JSONUtil;
import com.cqupt.laboratorysystem.common.dto.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @create 2023/6/13 20:30
 */
@Component
public class CaptchaFilter implements Filter {

    @Value("${captcha.enable}")
    private Boolean captchaEnable;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //只拦截登录请求，且开发环境下不拦截
        if("POST".equals(request.getMethod()) && "/login".equals(request.getRequestURI()) && captchaEnable){
            //从session中获取生成的验证码
            String verifyCode = request.getSession().getAttribute("verifyCode").toString();

            if (!verifyCode.toLowerCase().equals(request.getParameter("captcha").toLowerCase())){
                System.out.println("验证码错误");
                //响应json
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter out = response.getWriter();
                Result<Object> result = Result.fail("验证码错误");
                out.print(JSONUtil.toJsonStr(result));
                out.flush();
                out.close();
                return;
            }
        }

        chain.doFilter(servletRequest,servletResponse);
    }
}
