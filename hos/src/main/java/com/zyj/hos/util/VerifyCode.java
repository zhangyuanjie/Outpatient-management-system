package com.zyj.hos.util;

import java.util.Random;

/**
 * @author zyj
 * @date 2020/4/5 10:27
 */
public class VerifyCode {
    // 用于生成6位随机数字的验证码
    public static String getVCode(){
        Random random = new Random();
        String vCode = String.valueOf((random.nextInt(899999) + 10000));
        return vCode;
    }

    // 用于判断验证码生成的时间差
}
