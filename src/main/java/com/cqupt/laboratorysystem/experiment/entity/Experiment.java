package com.cqupt.laboratorysystem.experiment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cqupt.laboratorysystem.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @create 2023/4/30 16:24
 */
@Data
@ApiModel("实验类")
@TableName("experiment_details")
public class Experiment extends BaseEntity {

    @ApiModelProperty(value = "实验内容")
    private String content;

    @ApiModelProperty(value = "实验发起者id")
    private Long ownId;

    /**
     * 实验级别
     * 1:普通任务
     * 2:紧急任务
     */
    @ApiModelProperty(value = "实验级别")
    private Integer level;

    /**
     * 实验状态
     * -1表示已取消
     * 0表示排队中
     * 1表示进行中
     * 2表示已完成
     */
    @ApiModelProperty(value = "实验状态")
    private Integer status;

    @ApiModelProperty(value = "实验创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "实验更新时间")
    private LocalDateTime updateTime;

}
