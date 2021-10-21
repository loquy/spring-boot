package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("test");
        mailMessage.setText("test");

        mailMessage.setTo("841243659@qq.com");
        mailMessage.setFrom("841243659@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("test1");
        helper.setText("<p>test1<p>", true);

        helper.addAttachment("1.jpg", new File("C:\\Users\\84124\\Pictures\\微信图片_20191025153108.jpg"));

        helper.setTo("841243659@qq.com");
        helper.setFrom("841243659@qq.com");

        mailSender.send(mimeMessage);
    }

}
