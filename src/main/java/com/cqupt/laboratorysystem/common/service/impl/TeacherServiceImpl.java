package com.cqupt.laboratorysystem.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.common.mapper.TeacherMapper;
import com.cqupt.laboratorysystem.common.entity.Teacher;
import com.cqupt.laboratorysystem.common.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @create 2023/5/4 10:25
 */
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}
