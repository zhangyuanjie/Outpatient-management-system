package com.zyj.hos.controller;

import com.zyj.hos.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author zyj
 * @date 2020/4/5 10:47
 */
@RestController
public class MailController {
    @Resource
    private MailService mailService;
    @Value("${spring.mail.username}")
    private String sender;

    @RequestMapping("/sendVCode")
    public String getVCode(HttpServletRequest request, @RequestParam String to){
        String subject = "获取验证码"; // 邮件主题
        Random random = new Random();
        String vCode = String.valueOf((random.nextInt(899999) + 10000)); // 生成随机6位数字的验证码
        System.out.println(vCode);
        try{
            mailService.sendVCodeMail(sender, to, subject, vCode);
            request.getSession().setAttribute("vCode",vCode);
            return "send mail success";
        }catch (Exception e){
            e.printStackTrace();
            return "send mail fail";
        }
    }
}
