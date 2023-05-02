package com.cqupt.laboratorysystem.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.annotation.MyAnnotation;
import com.cqupt.laboratorysystem.dao.ExperimentMapper;
import com.cqupt.laboratorysystem.pojo.Experiment;
import com.cqupt.laboratorysystem.service.ExperimentService;
import org.springframework.stereotype.Service;

/**
 * @create 2023/4/30 16:53
 */
@Service
public class ExperimentServiceImpl extends ServiceImpl<ExperimentMapper, Experiment> implements ExperimentService {
}
