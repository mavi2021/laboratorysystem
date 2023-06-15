package com.cqupt.laboratorysystem.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @create 2023/6/15 0:13
 */
@Data
@ApiModel(value="Page", description="用户管理对象")
public class Page implements Serializable {

    @ApiModelProperty(value = "当前页码")
    private Integer currentPage;

    @ApiModelProperty(value = "分页大小")
    private Integer pageSize;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    
    public Long getStart(){
        return (currentPage - 1L) * pageSize;
    }
}