package com.zyj.hos.service;

import com.zyj.hos.dao.MailMapper;

/**
 * @author zyj
 * @date 2020/4/4 20:43
 */
public interface MailService extends MailMapper {
    public void sendSimpleMail(String sender, String to, String subject, String content);
    public void sendVCodeMail(String sender,String to, String subject, String vCode);
}
