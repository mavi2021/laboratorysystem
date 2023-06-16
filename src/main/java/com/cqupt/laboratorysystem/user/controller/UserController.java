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
    @ApiOperation("获取用户分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchCondition", value = "用户搜索条件信息", required = true, dataType = "UserSearchCondition", paramType = "body"
    )})
    public Result<Object> pageList(@Valid UserSearchCondition searchCondition){
        return userService.pageList(searchCondition);
    }

    @PostMapping("/add")
    @ApiOperation("添加用户")
    public Result<Object> add(@Valid @RequestBody User user){
        return userService.add(user);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除用户")
    public Result<Object> delete(@PathVariable("id") @Valid Long id){
        return userService.deleteById(id);
    }

    @PutMapping("/update")
    @ApiOperation("修改用户")
    public Result<Object> update(@Valid @RequestBody User user){
        //使用乐观锁修改用户
        return userService.updateWithOptimisticLock(user);
    }

    @PostMapping("/register")
    @ApiOperation("注册用户")
    public Result<Object> registerUser(@Valid @RequestBody User user){
        return userService.register(user);
    }


}
