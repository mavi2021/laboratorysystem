package com.cqupt.laboratorysystem.service;

import com.cqupt.laboratorysystem.dto.Result;

/**
 * @create 2023/5/2 21:40
 */
public interface LoginService {
    Result sendCode();

    <T>Result login(Class<T>user);

}
