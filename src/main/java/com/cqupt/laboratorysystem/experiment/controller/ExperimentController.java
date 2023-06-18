package com.cqupt.laboratorysystem.experiment.controller;

import com.cqupt.laboratorysystem.common.annotation.Limit;
import com.cqupt.laboratorysystem.common.base.BaseServiceImpl2;
import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.experiment.condition.ExperimentSearchCondition;
import com.cqupt.laboratorysystem.experiment.entity.Experiment;
import com.cqupt.laboratorysystem.experiment.service.ExperimentService;
import com.cqupt.laboratorysystem.experiment.service.impl.ExperimentServiceImpl;
import com.cqupt.laboratorysystem.user.condition.UserSearchCondition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @create 2023/4/30 16:03
 */
@RestController
@RequestMapping("/experiment")
@RequiredArgsConstructor
@Api(tags = "实验管理相关接口")
public class ExperimentController {

    private final ExperimentServiceImpl experimentService;
//        private  ExperimentServiceImpl experimentService;
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

    @GetMapping("/getListByPage")
    @ApiOperation("获取实验分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchCondition", value = "实验搜索条件信息", required = true, dataType = "ExperimentSearchCondition", paramType = "body"
            )})
    public Result<Object> getListByPage(@Valid ExperimentSearchCondition searchCondition){
        return experimentService.getListByPage(searchCondition);
    }

    /**
     * 根据id删除实验
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("根据id删除实验")
    public Result delete(@PathVariable("id") Long id){
        return Result.success(experimentService.removeById(id));
    }

    /**
     * 根据id添加实验
     * @param experiment
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Experiment experiment){
        return experimentService.add(experiment);
    }

    /**
     * 根据id修改实验
     * @param experiment
     * @return
     */
    @PutMapping("/update")
    @ApiOperation("根据id修改实验")
    public Result update(@RequestBody Experiment experiment){
        return Result.success(experimentService.updateById(experiment));
    }

}
