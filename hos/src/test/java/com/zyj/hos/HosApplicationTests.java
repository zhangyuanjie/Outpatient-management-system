package com.zyj.hos;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.zyj.hos.dao.UserMapper;
import com.zyj.hos.entity.DrugList;
import com.zyj.hos.service.DrugListService;
import com.zyj.hos.service.DrugService;
import com.zyj.hos.service.PrescriptionService;
import com.zyj.hos.service.RegistrationService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.List;

@SpringBootTest
class HosApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private PrescriptionService prescriptionService;

    @Resource
    private DrugListService drugListService;

    @Resource
    private DrugService drugService;

    @Resource
    private RegistrationService registrationService;

    @Test
    void select() throws MessagingException {
        String vCode = "123456";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        try {
            messageHelper.setSubject("验证码");
            messageHelper.setFrom("1152223522@qq.com");
            messageHelper.setTo("1152223522@qq.com");
            messageHelper.setText("<h1>验证码</h1><br/><p>你好，你的验证码是："
                    + vCode +
                    "<br/>你可以复制此验证码并返回校医院门诊系统，以验证你的邮箱</p>", true);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

        try {
            javaMailSender.send(messageHelper.getMimeMessage());
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            System.out.println("发送邮件是发生异常！");
        }
    }

//    MD5加密密码
    @Test
    void updatePwd(){
        Integer userId = 123456789;
        String userId2 = userId + "";
        ByteSource salt = ByteSource.Util.bytes(userId2);
        String pwdWithMD5Salt1 = new Md5Hash("123456789",salt,1).toString();
        String pwdWithMD5Salt2 = new Md5Hash("123456789",salt,2).toString();
        String pwdWithMD5Salt3 = new Md5Hash("123456789",salt,2).toString();
        System.out.println(userId);
        System.out.println(salt);
        System.out.println(pwdWithMD5Salt1);
        System.out.println(pwdWithMD5Salt2);
        System.out.println(pwdWithMD5Salt3);
    }

    @Test
    void test(){
        Integer i = null;
        System.out.println( registrationService.selectTodayReg(null));
    }

    @Test
    void updatePwd2(){
        List<String> prescriptionIds = prescriptionService.selectTimeOutPre();
        System.out.println(prescriptionIds);
        prescriptionService.updateTimeOutPre();
        List<DrugList> drugLists = drugListService.selectTimeOutDrug(prescriptionIds);
        System.out.println(drugLists);
    }

    @Test
    void contextLoads() {
        DrugList drugList = new DrugList();
        drugList.setDrugId(1);
        drugList.setDrugNum(5);
        drugService.returnDrug(drugList);
    }

}
