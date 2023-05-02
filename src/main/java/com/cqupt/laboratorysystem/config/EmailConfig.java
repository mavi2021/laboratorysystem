package com.cqupt.laboratorysystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @create 2023/5/1 17:55
 */
@Configuration
public class EmailConfig {

    private static final String PROTOCOL = "mail.transport.protocol";
    private static final String AUTH = "mail.smtp.auth";
    private static final String ENABLE_STARTTLS = "mail.smtp.starttls.enable";
    private static final String DEBUG = "mail.debug";

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private Integer port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("{spring.mail.password}")
    private String password;

    @Value("{spring.mail.protocol}")
    private String protocol;

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setProtocol("smtp");
        return javaMailSender;
    }
}
