package com.cqupt.laboratorysystem.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @create 2023/5/4 10:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("teacher_role")
public class Teacher {

    /**
     * 教师id
     */
    private String id;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师账号用户名
     */
    private String userName;

    /**
     * 教师账号密码
     */
    private String userPassword;

    /**
     * 教师账号权限
     */
    private String roles;

    /**
     * 教师所属实验室
     */
    private String laboratory;

    /**
     * 教师所属学院
     */
    private String college;

    /**
     * 是否被封禁
     */
    private Boolean enabled;

    /**
     * 教师账号创建时间
     */
    private LocalDateTime createTime;

    /**
     * 教师账号更新时间
     */
    private LocalDateTime updateTime;

}
