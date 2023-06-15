package com.cqupt.laboratorysystem.controller;

import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.pojo.User;
import com.cqupt.laboratorysystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @create 2023/6/13 22:17
 */
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @GetMapping("/list")
//    @ResponseBody
//    public Result<Object> getEmpList(EmpQuery param){
//        List<Emp> list = empService.getEmpList(param);
//        Long count = empService.countEmpList(param);
//        return Result.success(list,count);
//    }


}
