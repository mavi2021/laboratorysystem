package com.cqupt.laboratorysystem.service.serviceImpl;

import com.cqupt.laboratorysystem.service.TaskService;
import com.cqupt.laboratorysystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @create 2023/5/2 10:49
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private EmailService emailService;

    //    @Scheduled(fixedRate = 6000)
    @Override
    @Scheduled(cron = "0 0 0 ? * SUN")
    public void countAttendance() {
        emailService.sendSimpleEmail("1095995425@qq.com","hi","hello");
    }
}
