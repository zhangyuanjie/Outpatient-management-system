package com.zyj.hos.service.impl;

import com.zyj.hos.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author zyj
 * @date 2020/4/4 20:43
 */
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender  mailSender;

    @Override
    public void sendSimpleMail(String sender, String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender); // 发件人
        message.setTo(to); // 收件人
        message.setSubject(subject); // 主题
        message.setText("简单邮箱测试" + content);

        try {
            mailSender.send(message);
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            System.out.println("发送邮件是发生异常！");
        }
    }

    @Override
    public void sendVCodeMail(String sender, String to, String subject, String vCode) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        try {
            messageHelper.setSubject(subject);// 主题
            messageHelper.setFrom(sender);
            messageHelper.setTo(to);
            messageHelper.setText("<h1>验证码</h1><br/><p>你好，你的验证码是：" + vCode + "<br/>你可以复制此验证码并返回校医院门诊系统，以验证你的邮箱</p>", true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            mailSender.send(messageHelper.getMimeMessage());
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            System.out.println("发送邮件是发生异常！");
        }
    }
}
