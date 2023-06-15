package com.cqupt.laboratorysystem.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @create 2023/6/13 22:08
 */
@Data
@TableName("user")
public class User implements Serializable {

    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "用户登录名")
    private String loginName;

    @ApiModelProperty(value = "用户昵称")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户权限")
    private String roles;

    @ApiModelProperty(value = "用户所属实验室")
    private String laboratory;

    @ApiModelProperty(value = "用户所属学院")
    private String college;

    @ApiModelProperty(value = "用户是否被封禁")
    private int enabled;

    @ApiModelProperty(value = "用户是否被删除")
    private int isDeleted;

    @ApiModelProperty(value = "用户账号创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "用户账号删除时间")
    private LocalDateTime deleteTime;

    @ApiModelProperty(value = "用户账号最后更新时间")
    private LocalDateTime updateTime;

}
