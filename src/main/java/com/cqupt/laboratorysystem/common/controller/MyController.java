package com.cqupt.laboratorysystem.common.controller;

import com.cqupt.laboratorysystem.common.annotation.MyAnnotation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2023/5/1 11:45
 */
@RestController
@RequestMapping("/my")
public class MyController {

    @MyAnnotation(value = "NoREAD")
    private String myname;

    @PostMapping("/test")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "heihei";
    }
}
