package com.cqupt.laboratorysystem.common.handler;

import com.aliyun.oss.ServiceException;
import com.cqupt.laboratorysystem.common.dto.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @create 2023/6/15 16:24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException e) {
        return Result.fail(e.getMessage());
    }

}
