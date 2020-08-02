package com.zyj.hos.controller;

import com.zyj.hos.entity.Admin;
import com.zyj.hos.entity.Doctor;
import com.zyj.hos.entity.User;
import com.zyj.hos.service.AdminService;
import com.zyj.hos.service.DoctorService;
import com.zyj.hos.service.RegistrationService;
import com.zyj.hos.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {

    @Resource
    private UserService userService;

    @Resource
    private AdminService adminService;

    @Resource
    private DoctorService doctorService;

    @Resource
    private RegistrationService registrationService;

    @RequestMapping("/cover")
    public String cover(){
        return "cover";
    }

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/forgetPwd")
    public String forgetPwd(){
        return "forgetPwd";
    }

    @RequestMapping("/tologin")
    public String toLogin(){
        System.out.println("tologin");
        return "login";
    }

    @RequestMapping("/noauth") // 未经授权无妨访问
    @ResponseBody
    public String unauthorized(){
        return "尚未登录或时间太久，请重新刷新此页面";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user,@RequestParam String vCode, HttpServletRequest request){
        try{
            String account = user.getUserAccount();
            String userPwd = user.getUserPwd();
            if(userService.selectUserByAccount(account)!=null){
                return "account is exist";
            }else if(doctorService.selectDoctorByAccount(account)!=null){
                return "account is exist";
            }else if(adminService.selectAdminByAccount(account)!=null){
                return "account is exist";
            }
            else {
                String code = (request.getSession().getAttribute("vCode")).toString();
                System.out.println(code);
                if(vCode.equals(code)){
                    // 对密码进行盐值加密
                    // 盐值由用户账号进行转换而得
                    ByteSource salt = ByteSource.Util.bytes(account);
                    // 经过盐值 2 次加密后的密码
                    String pwdWithMD5Salt = new Md5Hash(userPwd,salt,2).toString();
                    user.setUserPwd(pwdWithMD5Salt);
                    userService.insertUserByEmail(user);
                    return "insert user success";
                }else {
                    return "vCode is error";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "insert user fail";
        }
    }

    @RequestMapping("/selectEmailByAccount")
    @ResponseBody
    public String selectEmailByAccount(@RequestParam String account){
        try{
            if(userService.selectUserByAccount(account)!=null){
                User user = userService.selectUserByAccount(account);
                return user.getUserEmail();
            }else if(doctorService.selectDoctorByAccount(account)!=null){
                Doctor doctor = doctorService.selectDoctorByAccount(account);
                return doctor.getDoctorEmail();
            }else if(adminService.selectAdminByAccount(account)!=null){
                Admin admin = adminService.selectAdminByAccount(account);
                return admin.getAdminEmail();
            }
            else {
               return "account is not exist";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/updateForgetPwd")
    @ResponseBody
    public String updateForgetPwd(@RequestParam String account, @RequestParam String pwd ,@RequestParam String vCode, HttpServletRequest request) {
        try{
            String code = (request.getSession().getAttribute("vCode")).toString();
            System.out.println(code);
            if(vCode.equals(code)){
                ByteSource salt = ByteSource.Util.bytes(account);
                // 经过盐值 2 次加密后的密码
                String pwdWithMD5Salt = new Md5Hash(pwd,salt,2).toString();
                if(userService.selectUserByAccount(account)!=null){
                    User user = new User();
                    user.setUserAccount(account);
                    user.setUserPwd(pwdWithMD5Salt);
                    userService.updatePwdByAccount(user);

                }else if(doctorService.selectDoctorByAccount(account)!=null){
                    Doctor doctor = new Doctor();
                    doctor.setDoctorAccount(account);
                    doctor.setDoctorPwd(pwdWithMD5Salt);
                    doctorService.updatePwdByAccount(doctor);
                }else if(adminService.selectAdminByAccount(account)!=null){
                    Admin admin = new Admin();
                    admin.setAdminAccount(account);
                    admin.setAdminPwd(pwdWithMD5Salt);
                    adminService.updatePwdByAccount(admin);
                }
                return "update pwd success";
            }else {
                return "vCode is error";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/timeOutReg")
    @ResponseBody
    public String timeOugReg(){
        registrationService.timeOutReg();
        return "some reg timeOut";
    }

//    @RequestMapping("/logout")
//    public String logout(){
//        System.out.println("logout");
//        return "login";
//    }
}
