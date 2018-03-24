package com.example.mail.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
public class MailController {

    @Autowired
    JavaMailSender mailSender;

    @ResponseBody
    @RequestMapping("/send")
    public Object sendEmail(String content) {
        try {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom("2286824491@qq.com");
            message.setTo("635368604@qq.com");
            message.setSubject("测试邮件主题");
            message.setText(content);

           // message.setText("这个是邮件的所有目录",true)  ;  // html格式

            this.mailSender.send(mimeMessage);

            return "sucesss";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
        }
    }
}
