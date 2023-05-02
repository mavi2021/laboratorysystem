package com.cqupt.laboratorysystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.cqupt.laboratorysystem.dao")
public class LaboratorysystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaboratorysystemApplication.class, args);
    }

}
