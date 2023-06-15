package com.cqupt.laboratorysystem.user.vo;

import com.cqupt.laboratorysystem.common.vo.Search;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @create 2023/6/15 0:12
 */
@ApiModel(value="Search", description="基础搜索对象")
public class UserSearchVo extends Search{

    @ApiModelProperty(value = "搜索用户名")
    private String name;

}
