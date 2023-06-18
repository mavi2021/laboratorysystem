package com.cqupt.laboratorysystem.experiment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.common.annotation.Log;
import com.cqupt.laboratorysystem.common.base.BaseServiceImpl;
import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.experiment.condition.ExperimentSearchCondition;
import com.cqupt.laboratorysystem.experiment.mapper.ExperimentMapper;
import com.cqupt.laboratorysystem.experiment.entity.Experiment;
import com.cqupt.laboratorysystem.experiment.service.ExperimentService;
import com.cqupt.laboratorysystem.user.condition.UserSearchCondition;
import com.cqupt.laboratorysystem.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @create 2023/4/30 16:53
 */
@Service
@Slf4j
public class ExperimentServiceImpl extends BaseServiceImpl<ExperimentMapper,Experiment> implements ExperimentService{

//    public ExperimentServiceImpl() {
//        super();
//    }
}
