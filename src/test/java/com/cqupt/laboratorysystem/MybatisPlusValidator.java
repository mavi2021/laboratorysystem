package com.cqupt.laboratorysystem;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cqupt.laboratorysystem.user.entity.User;
import com.cqupt.laboratorysystem.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @create 2023/6/14 1:46
 */
@SpringBootTest
@RequiredArgsConstructor
public class MybatisPlusValidator {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void test(){
        String username = "yin";
        LambdaQueryWrapper<User> teacherLambdaQueryWrapper = new LambdaQueryWrapper<>();
        teacherLambdaQueryWrapper.eq(username!=null, User::getLoginName, username);
        User user = userService.getOne(teacherLambdaQueryWrapper);
//        User user = userService.getById(1);
        System.out.println(user);
    }

    @Test
    public void validatePassword(){
        String password = "123456";
        boolean matches = bCryptPasswordEncoder.matches(bCryptPasswordEncoder.encode(password),userService.getById(1).getPassword());
        System.out.println(matches);
    }
}
