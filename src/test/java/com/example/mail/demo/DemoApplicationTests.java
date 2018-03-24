package com.example.mail.demo;

import com.example.mail.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    String to = "2286824491@qq.com";

    @Autowired
    private MailService service;

    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void contextLoads() {

        String filpath = "C:\\Users\\liliangbin\\Pictures\\Camera Roll\\post-bg.jpg";

        service.sendAttachmentsMail(to, "添加附件", "这个是一个有附件的邮件", filpath);
    }


    @Test
    public void fjjfjf() {

        String content = "dkfhsdkfhbghfghfggf";

        service.sendHtmlMail(to, "jfhfhfhhf", content);
    }


    @Test
    public void fhdhfhfh() {
        String rscId = "neo006";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\liliangbin\\Pictures\\Camera Roll\\timg.jpg";

       service.sendInlineResourceMail(to, "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    @Test
    public void fff(){

        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

      service.sendHtmlMail(to,"主题：这是模板邮件",emailContent);
    }
}
