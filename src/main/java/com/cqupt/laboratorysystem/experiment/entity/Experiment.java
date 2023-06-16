package com.cqupt.laboratorysystem.experiment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @create 2023/4/30 16:24
 */
@Data
@ApiModel("实验类")
@TableName("experiment_details")
public class Experiment {

    /**
     * 实验id
     */
//    @TableId(value = "id")
    private Long id;

    /**
     * 实验内容
     */
    private String content;

    /**
     * 实验发起者id
     */
    private Long ownId;

    /**
     * 实验级别
     * 1:普通任务
     * 2:紧急任务
     */
    private Integer level;

    /**
     * 任务状态
     * -1表示已取消
     * 0表示排队中
     * 1表示进行中
     * 2表示已完成
     */
    private Integer status;

    /**
     * 实验创建时间
     */
    private LocalDateTime createTime;

    /**
     * 实验更新时间
     */
    private LocalDateTime updateTime;

}
