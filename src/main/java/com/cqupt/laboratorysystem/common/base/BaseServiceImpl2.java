package com.cqupt.laboratorysystem.common.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.experiment.entity.Experiment;
import com.cqupt.laboratorysystem.experiment.mapper.ExperimentMapper;
import com.cqupt.laboratorysystem.experiment.service.ExperimentService;
import org.springframework.stereotype.Service;

/**
 * @create 2023/6/18 11:06
 */
//@Service
public class BaseServiceImpl2 extends ServiceImpl<ExperimentMapper, Experiment> implements ExperimentService {

    public BaseServiceImpl2() {
        super(); // 调用父类的构造方法，传递 Mapper 对象
    }

}
