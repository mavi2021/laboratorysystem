package com.cqupt.laboratorysystem.common.service.impl;

import com.cqupt.laboratorysystem.common.service.TaskService;
import com.cqupt.laboratorysystem.common.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @create 2023/5/2 10:49
 */
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final EmailService emailService;

    //    @Scheduled(fixedRate = 6000)
    @Override
    @Scheduled(cron = "0 0 0 ? * SUN")
    public void countAttendance() {
        emailService.sendSimpleEmail("1095995425@qq.com","hi","hello");
    }
}
