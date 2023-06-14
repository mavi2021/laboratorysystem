package com.cqupt.laboratorysystem.controller;

import com.cqupt.laboratorysystem.common.annotation.Limit;
import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.pojo.Experiment;
import com.cqupt.laboratorysystem.service.ExperimentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @create 2023/4/30 16:03
 */
@Api(tags = "实验管理相关接口")
@RequestMapping("/experiment")
@RestController
public class ExperimentController {

    @Autowired
    private ExperimentService experimentService;

    /**
     * 查询所有实验详情
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("查询所有实验详情")
    @Limit(period = 60, requestLimitMaxNum = 100, type = "ip")
    public Result queryExperimentList(){
        return Result.success(experimentService.query().list());
    }

    /**
     * 根据id查询实验详情
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    @ApiOperation("根据id查询实验详情")
    public Result queryExperimentById(@PathVariable("id") Long id){
        return Result.success(experimentService.getById(id));
    }

    /**
     * 根据id删除实验
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("根据id删除实验")
    public Result deleteExperimentById(@PathVariable("id") Long id){
        return Result.success(experimentService.removeById(id));
    }

    /**
     * 根据id添加实验
     * @param experiment
     * @return
     */
    @PostMapping("/add")
    public Result addExperimentById(@RequestBody Experiment experiment){
        return Result.success(experimentService.save(experiment));
    }

    /**
     * 根据id修改实验
     * @param experiment
     * @return
     */
    @PutMapping("/update")
    @ApiOperation("根据id修改实验")
    public Result updateExperimentById(@RequestBody Experiment experiment){
        return Result.success(experimentService.updateById(experiment));
    }

}
