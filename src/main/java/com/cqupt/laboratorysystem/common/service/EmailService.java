package com.cqupt.laboratorysystem.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @create 2023/5/1 18:04
 */
public interface EmailService{
    void sendSimpleEmail(String receiver, String subject, String text);
}
