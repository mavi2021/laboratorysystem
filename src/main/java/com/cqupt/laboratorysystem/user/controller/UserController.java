package com.cqupt.laboratorysystem.user.controller;

import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.user.condition.UserSearchCondition;
import com.cqupt.laboratorysystem.user.entity.User;
import com.cqupt.laboratorysystem.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @create 2023/6/13 22:17
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(tags = {"用户接口"})
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    @ApiOperation("获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchCondition", value = "用户搜索条件信息", required = true, dataType = "UserSearchCondition", paramType = "body"
    )})
    public Result<Object> getUserList(@Valid UserSearchCondition searchCondition){
        return userService.getUserList(searchCondition);
    }

    @PostMapping("/add")
    @ApiOperation("添加用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "user", value = "添加用户信息", required = true, dataType = "User", paramType = "body"
//            )})
    public Result<Object> addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }


    @DeleteMapping("/delete")
    @ApiOperation("删除用户")
    public Result<Object> deleteUser(@Valid Integer id){
        return userService.deleteUserById(id);
    }

    @PutMapping("/update")
    @ApiOperation("修改用户")
    public Result<Object> updateUser(@Valid @RequestBody User user){
        return userService.updateUser(user);
    }


}
