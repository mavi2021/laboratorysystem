package com.cqupt.laboratorysystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAspectJAutoProxy
@MapperScan("com.cqupt.laboratorysystem.dao")
public class LaboratorysystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaboratorysystemApplication.class, args);
    }

}
