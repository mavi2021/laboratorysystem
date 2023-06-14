package com.cqupt.laboratorysystem.service.serviceImpl;

import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.pojo.Teacher;
import com.cqupt.laboratorysystem.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @create 2023/5/2 21:40
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

//    private final

    @Override
    public Result sendCode() {
        log.debug("发送验证码");
        return Result.fail("功能未完成");
    }



//    @Override
//    public <T> Result login(Class<T> user) {
//
//        return Result.fail("功能未完成");

    public Result login(Teacher user) {

        return Result.fail("功能未完成");
    }
}
