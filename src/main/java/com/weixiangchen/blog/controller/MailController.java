package com.weixiangchen.blog.controller;

import com.weixiangchen.blog.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mail")
@RestController
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send")
    public String sendMail(@RequestBody Email email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email.getRecipient());
        simpleMailMessage.setFrom("陈为响<1981468862@qq.com>");
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getText());
        mailSender.send(simpleMailMessage);
        return "ok";
    }
}
