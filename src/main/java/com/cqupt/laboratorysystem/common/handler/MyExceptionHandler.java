package com.cqupt.laboratorysystem.common.handler;
import com.cqupt.laboratorysystem.common.dto.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @create 2023/6/12 17:25
 */
//@ControllerAdvice
//public class MyExceptionHandler {
//
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public Result<Object> myHandler(Exception e){
//
//        System.out.println("系统错误：" + e.getMessage());
//
//        return Result.fail("系统错误：" + e.getMessage());
//    }
//}