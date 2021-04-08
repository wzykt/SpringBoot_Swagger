package com.wzy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.io.File;

@SpringBootTest
class SpringbootSwaggerApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //简单邮件测试，带附件的邮件使用MimeMessage
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("test");
        mailMessage.setText("邮件测试");
        mailMessage.setTo("1540697727@qq.com");
        mailMessage.setFrom("1540697727@qq.com");
        mailSender.send(mailMessage);
    }

    //邮件处理方法
    public void sendMail(String text, String subject, File[] files,String sendTo,String sendFrom) throws MessagingException {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();

        //开启多邮件
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMailMessage,true);

        messageHelper.setText(text);
        messageHelper.setSubject(subject);
        messageHelper.addAttachment("1",files[0]);
        messageHelper.setTo(sendTo);
        messageHelper.setFrom(sendFrom);
        mailSender.send(mimeMailMessage);
    }

}
