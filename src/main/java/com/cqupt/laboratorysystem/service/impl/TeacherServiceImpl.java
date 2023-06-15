package com.cqupt.laboratorysystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.mapper.TeacherMapper;
import com.cqupt.laboratorysystem.entity.Teacher;
import com.cqupt.laboratorysystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @create 2023/5/4 10:25
 */
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}
