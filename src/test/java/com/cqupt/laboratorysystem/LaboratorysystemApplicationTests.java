package com.cqupt.laboratorysystem;

import com.cqupt.laboratorysystem.config.EmailConfig;
import com.cqupt.laboratorysystem.controller.MyController;
import com.cqupt.laboratorysystem.service.DocumentService;
import com.cqupt.laboratorysystem.service.LoginService;
import com.cqupt.laboratorysystem.service.serviceImpl.ExperimentServiceImpl;
import com.cqupt.laboratorysystem.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import static com.cqupt.laboratorysystem.utils.CommonEmails.*;

@SpringBootTest
@RequiredArgsConstructor
class LaboratorysystemApplicationTests {

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private MyController myController;

    @Autowired
    private EmailService emailService;
//    private final EmailService emailService;

//    @Autowired
//    private DocumentService documentService;
    private final DocumentService documentService;

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
