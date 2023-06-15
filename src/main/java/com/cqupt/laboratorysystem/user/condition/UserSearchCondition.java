package com.cqupt.laboratorysystem.user.condition;

import com.cqupt.laboratorysystem.common.condition.SearchCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @create 2023/6/15 1:05
 */
@Data
@ApiModel(value="UserSearchCondition", description="用户搜索条件对象")
public class UserSearchCondition extends SearchCondition {

    @ApiModelProperty(value = "搜索用户名")
    private String name;

    @ApiModelProperty(value = "搜索用户类型")
    private String type;

    @ApiModelProperty(value = "搜索用户所属实验室")
    private String laboratory;

}
