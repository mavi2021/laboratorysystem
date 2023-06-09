package com.cqupt.laboratorysystem;

import com.cqupt.laboratorysystem.common.config.EmailConfig;
import com.cqupt.laboratorysystem.common.controller.MyController;
import com.cqupt.laboratorysystem.common.service.DocumentService;
import com.cqupt.laboratorysystem.common.service.LoginService;
import com.cqupt.laboratorysystem.experiment.service.impl.ExperimentServiceImpl;
import com.cqupt.laboratorysystem.common.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
@RequiredArgsConstructor
class LaboratorysystemApplicationTests {

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private MyController myController;

    @Autowired
    private EmailService emailService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ApplicationContext applicationContext;


    @Test
//    @ParameterizedTest
    void contextLoads(){
        String filePath = "D:\\Workspace\\1.xlsx";
        documentService.upload(filePath);
//        System.out.println(loginService.sendCode());
//        emailService.sendSimpleEmail(MAIL_ME, "HELLOSHUHENG","HAHAHAHHAHA");
//        Object webSecurityConfigurerAdapter = applicationContext.getBean("WebSecurityConfigurerAdapter");
//        System.out.println(webSecurityConfigurerAdapter);
    }

}
