package com.cqupt.laboratorysystem.service;

import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.pojo.Teacher;

/**
 * @create 2023/5/2 21:40
 */
public interface LoginService {
    Result sendCode();

//    <T>Result login(Class<T>user);

    Result login(Teacher user);


}
