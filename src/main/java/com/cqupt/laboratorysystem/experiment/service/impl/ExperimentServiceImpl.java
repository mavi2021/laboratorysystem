package com.cqupt.laboratorysystem.experiment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.experiment.mapper.ExperimentMapper;
import com.cqupt.laboratorysystem.experiment.entity.Experiment;
import com.cqupt.laboratorysystem.experiment.service.ExperimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @create 2023/4/30 16:53
 */
@Service
@RequiredArgsConstructor
public class ExperimentServiceImpl extends ServiceImpl<ExperimentMapper, Experiment> implements ExperimentService {
}
