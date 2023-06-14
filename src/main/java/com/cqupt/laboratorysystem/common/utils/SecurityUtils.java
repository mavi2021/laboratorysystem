package com.cqupt.laboratorysystem.common.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @create 2023/5/6 16:30
 */
public class SecurityUtils {

    public Object getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
