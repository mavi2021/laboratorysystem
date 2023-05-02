package com.cqupt.laboratorysystem.controller;

import com.cqupt.laboratorysystem.annotation.MyAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : ZengJun
 * @create 2023/5/1 11:45
 */
@RestController
@RequestMapping("/my")
public class MyController {

    @MyAnnotation(value = "NoREAD")
    private String myname;
}
