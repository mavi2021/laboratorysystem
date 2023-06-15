package com.cqupt.laboratorysystem.common.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @create 2023/6/15 1:08
 */
@Data
@ApiModel(value="SearchCondition", description="基础搜索条件对象")
public class SearchCondition implements Serializable {

    @ApiModelProperty(value = "当前页码")
    private Integer currentPage;

    @ApiModelProperty(value = "分页大小")
    private Integer pageSize;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @ApiModelProperty(value = "逻辑删除")
    private Integer deleted;


//    public Long getStart(){
//        return (currentPage - 1L) * pageSize;
//    }
}