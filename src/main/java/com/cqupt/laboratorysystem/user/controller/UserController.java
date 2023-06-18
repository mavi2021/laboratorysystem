package com.cqupt.laboratorysystem.user.controller;

import com.cqupt.laboratorysystem.common.base.BaseController;
import com.cqupt.laboratorysystem.common.condition.SearchCondition;
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
public class UserController{

    private final UserService userService;

    @GetMapping("/getListByPage")
    @ApiOperation("获取分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchCondition", value = "搜索条件信息", required = true, dataType = "SearchCondition", paramType = "body"
    )})
    public Result<Object> getListByPage(@Valid SearchCondition searchCondition){

        return userService.getListByPage(searchCondition);
    }

    @PostMapping("/add")
    @ApiOperation("添加")
    public Result<Object> add(@Valid @RequestBody User user){
        return userService.add(user);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public Result<Object> delete(@PathVariable("id") @Valid Long id){
        return userService.deleteById(id);
    }

    @PutMapping("/update")
    @ApiOperation("修改")
    public Result<Object> update(@Valid @RequestBody User user){
        //使用乐观锁修改用户c
        return userService.update(user);
    }

    @GetMapping("/query/{id}")
    @ApiOperation("查询")
    public Result<Object> query(@PathVariable("id") @Valid Long id){
        return userService.queryById(id);
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public Result<Object> registerUser(@Valid @RequestBody User user){
        return userService.register(user);
    }


}
