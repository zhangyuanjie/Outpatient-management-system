package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.config.shiroConfig.UserToken;
import com.zyj.hos.entity.User;
import com.zyj.hos.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user")
    public String user(){
        return "/user/user";
    }

    @RequestMapping("/login")
    public String selectUser(@RequestParam String userAccount, @RequestParam String userPwd, Model model, HttpServletRequest request){
        System.out.println("user login");
        // 对密码进行盐值加密
        // 盐值由用户账号进行转换而得
        ByteSource salt = ByteSource.Util.bytes(userAccount);
        // 经过盐值 2 次加密后的密码
        String pwdWithMD5Salt = new Md5Hash(userPwd,salt,2).toString();
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录请求
        UserToken token = new UserToken(userAccount, pwdWithMD5Salt,"User");
        try{
            subject.login(token); // 执行登录方法，如果没有异常就说明 ok 了
            System.out.println("ok");
            // 获取当前登录账号的用户信息并传至session域中
            User currentUser = userService.selectUserByAccount(userAccount);
            request.getSession().setAttribute("currentUser",currentUser);
            return "user/user";
        }catch (UnknownAccountException e){ // 用户名不存在
            model.addAttribute("msg","账号或密码错误");
            System.out.println("用户名或密码错误");
            return  "login";
        }catch (IncorrectCredentialsException e2){ // 密码错误
            model.addAttribute("msg","账号或密码错误");
            System.out.println("用户名或密码错误");
            return  "login";
        }
    }

    @RequestMapping("/updateSelf")
    public String updateSelf(){
        return "user/self/updateSelf";
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(){
        return "user/self/updatePwd";
    }

    @RequestMapping("/registration1")
    public String registration1(){
        return "user/registration/registration1";
    }

    @RequestMapping("/toRegistration2WithId")
    public String toRegistration2WithId(String departmentId, Model model){
        System.out.println(departmentId);
        model.addAttribute("departmentId",departmentId);
        return "user/registration/registration2";
    }

    @RequestMapping("/toRegistration3WithId")
    public String toRegistration3WithId(String doctorId, String departmentId, Model model){
        System.out.println(doctorId);
        model.addAttribute("doctorId",doctorId);
        model.addAttribute("departmentId",departmentId);
        return "user/registration/registration3";
    }

    @RequestMapping("/registration2")
    public String registration2(){
        return "user/registration/registration2";
    }

    @RequestMapping("/registration3")
    public String registration3(){
        return "user/registration/registration3";
    }

    @RequestMapping("/userManager")
    public String userManager(){
        return "user/userManager";
    }

    @RequestMapping("/registrationDetails")
    public String registrationDetails(){
        return "user/registration/registrationDetails";
    }

    @RequestMapping("/registrationMore")
    public String registrationMore(){
        return "user/registration/registrationMore";
    }

    @RequestMapping("/medicalRecord")
    public String medicalRecord(){
        return "user/medicalRecord/medicalRecord";
    }

    @RequestMapping("/toMedicalRecordDetails")
    public String toMedicalRecordDetails(Model model, @RequestParam String recordId){
        model.addAttribute("recordId", recordId);
        return "user/medicalRecord/medicalRecordDetails";
    }

    @RequestMapping("/myPrescription")
    public String toMyPrescription(){
        return "user/prescription/myPrescription";
    }

    @RequestMapping("/toPrescriptionDetails")
    public String toPrescriptionDetails(Model model, @RequestParam String prescriptionId){
        model.addAttribute("prescriptionId", prescriptionId);
        return "user/prescription/prescriptionDetails";
    }

    @RequestMapping("/departmentManager")
    public String departmentManager(){
        return "user/msgSearch/departmentManager";
    }

    @RequestMapping("/doctorManager")
    public String doctorManager(){
        return "user/msgSearch/doctorManager";
    }

    @RequestMapping("/myBill")
    public String myBill(){
        return "user/myBill/myBill";
    }

    // 用于获取当前登录用户
    @RequestMapping("/selectCurrentUser")
    @ResponseBody
    public User selectCurrentUser(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("currentUser");// 获取前，必须得先登录，不然获取结果为空
        Integer userId = user.getUserId();
        User user1 = userService.selectUserById(userId);
        return user1;
    }

    @RequestMapping("/selectUserById")
    @ResponseBody
    public User selectUserById(@RequestParam Integer userId){
        return userService.selectUserById(userId);
    }

    @RequestMapping("/selectAllUser")
    @ResponseBody
    public PageInfo<User> selectAllUser(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<User> users = userService.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @RequestMapping("/selectUserByKey")
    @ResponseBody
    public PageInfo<User> selectUserByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, User user){
        PageHelper.startPage(pageNum,5);
        List<User> users = userService.selectUserByKey(user);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @RequestMapping("/updateUserById")
    @ResponseBody
    public String updateUserById(User user){
        try{
            userService.updateUserById(user);
            return "update user success";
        }catch (Exception e){
            e.printStackTrace();
            return "update user false";
        }
    }

    @RequestMapping("/selectPwdById")
    @ResponseBody
    public String selectPwdById(@RequestParam("userId") Integer userId,@RequestParam("pwd") String pwd, HttpServletRequest request){
        // 从数据库中获取旧密码
        String user_pwd = userService.selectPwdById(userId);
        // 将新密码通过盐值加密后，与旧密码相比较
        User user = (User)request.getSession().getAttribute("currentUser");
        String userAccount = user.getUserAccount();
        ByteSource salt = ByteSource.Util.bytes(userAccount); // 根据用户账号转换的盐值
        String pwdWithMD5Salt = new Md5Hash(pwd,salt,2).toString();
        if (pwdWithMD5Salt.equals(user_pwd)){
            return "pwd right";
        }
        return "pwd error";
    }

    @RequestMapping("/updatePwdById")
    @ResponseBody
    public String updatePwdById(User user, HttpServletRequest request){
        // 密码需过MD5盐值加密之后才能录入数据库中
        String userAccount = ((User)request.getSession().getAttribute("currentUser")).getUserAccount();// 获取当前登录用户的账号
        ByteSource salt = ByteSource.Util.bytes(userAccount); // 用户对应的盐值
        String pwd = user.getUserPwd();
        String pwdWithMD5Salt = new Md5Hash(pwd,salt,2).toString();
        user.setUserPwd(pwdWithMD5Salt);
        try{
            userService.updatePwdById(user);
            return "update pwd success";
        }catch (Exception e){
            e.printStackTrace();
            return "update pwd false";
        }
    }
}
