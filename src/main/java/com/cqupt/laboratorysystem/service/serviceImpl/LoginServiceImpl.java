package com.cqupt.laboratorysystem.service.serviceImpl;

import com.cqupt.laboratorysystem.annotation.Limit;
import com.cqupt.laboratorysystem.dto.Result;
import com.cqupt.laboratorysystem.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @create 2023/5/2 21:40
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Override
    @Limit(period = 60, requestNum = 100)
    public Result sendCode() {
        log.debug("发送验证码");
        return Result.fail("功能未完成");
    }
}
