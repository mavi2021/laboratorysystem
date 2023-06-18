package com.cqupt.laboratorysystem.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @create 2023/6/18 1:08
 */
@Data
public class BaseEntity {
    @ApiModelProperty(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;
}
