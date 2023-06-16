package com.cqupt.laboratorysystem.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @create 2023/6/13 22:08
 */
@Data
@TableName("user")
@ApiModel(value="User", description="用户管理对象")
public class User implements Serializable {

    @ApiModelProperty(value = "用户id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户所属租户ID")
    private Long tenantId;

    @ApiModelProperty(value = "用户登录名")
    private String loginName;

    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户手机号码")
    private String phone;

    @ApiModelProperty(value = "用户类型")
    private String type;

    @ApiModelProperty(value = "用户权限")
    private String roles;

    @ApiModelProperty(value = "用户所属实验室")
    private String laboratory;

    @ApiModelProperty(value = "用户所属学院")
    private String college;

    @ApiModelProperty(value = "用户审核状态")
    private Integer auditStatus;

    @ApiModelProperty(value = "用户封禁状态")
    private Integer enabled;

    @ApiModelProperty(value = "用户删除状态")
//    @TableLogic(value = "0", delval = "1")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "执行删除操作的用户ID")
    private Integer deletedBy;

    @ApiModelProperty(value = "第三方登录ID")
    private String thirdPartyId;

    @ApiModelProperty(value = "第三方登录类型")
    private String thirdPartyType;

    @ApiModelProperty(value = "用户最后登录时间")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "用户最后操作时间")
    private LocalDateTime lastOperateTime;

    @ApiModelProperty(value = "用户账号创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "用户账号删除时间")
    private LocalDateTime deleteTime;

    @ApiModelProperty(value = "用户账号最后更新时间")
//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Version
    @ApiModelProperty(value = "用户账号数据版本号")
    private Integer version;
}
