package com.cqupt.laboratorysystem;

import com.cqupt.laboratorysystem.controller.MyController;
import com.cqupt.laboratorysystem.service.DocumentService;
import com.cqupt.laboratorysystem.service.serviceImpl.ExperimentServiceImpl;
import com.cqupt.laboratorysystem.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.cqupt.laboratorysystem.utils.CommonEmails.MAIL_GUOQING;
import static com.cqupt.laboratorysystem.utils.CommonEmails.MAIL_ME;

@SpringBootTest
class LaboratorysystemApplicationTests {

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private MyController myController;

    @Autowired
    private EmailService emailService;

    @Autowired
    private DocumentService documentService;
    @Test
    void contextLoads(){
        String filePath = "D:\\Workspace\\1.xlsx";
        documentService.upload(filePath);

//        emailService.sendSimpleEmail(MAIL_ME, "HELLOSHUHENG","HAHAHAHHAHA");

    }

}
