package com.cqupt.laboratorysystem.common.handler;

import com.aliyun.oss.ServiceException;
import com.cqupt.laboratorysystem.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @create 2023/6/15 16:24
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException e) {

        log.error("执行失败：" + e.getMessage());
        return Result.error(e.getMessage());
    }

}
