package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.config.shiroConfig.UserToken;
import com.zyj.hos.entity.Admin;
import com.zyj.hos.entity.Doctor;
import com.zyj.hos.entity.User;
import com.zyj.hos.service.AdminService;
import com.zyj.hos.service.DoctorService;
import com.zyj.hos.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;

    @Resource
    private DoctorService doctorService;

    @RequestMapping("/admin")
    public String welcome(){
        return "admin/admin";
    }

    @RequestMapping("/adminIndex")
    public String toAdminIndex(){
        return "admin/adminIndex";
    }

    @RequestMapping("/updateSelf")
    public String toUpdateSelf(){
        return "admin/adminSelf/updateSelf";
    }

    @RequestMapping("/updatePwd")
    public String toUpdatePwd(){
        return "admin/adminSelf/updatePwd";
    }

    @RequestMapping("/userManager")
    public String toUserManager(){
        return "admin/userManager/userManager";
    }

    @RequestMapping("/userAdd")
    public String toUserAdd(){
        return "admin/userManager/userAdd";
    }

    @RequestMapping("/adminManager")
    public String toAdminManager(){
        return "admin/adminManager/adminManager";
    }

    @RequestMapping("/adminAdd")
    public String toAdminAdd(){
        return "admin/adminManager/adminAdd";
    }

    @RequestMapping("/departmentManager")
    public String toDepartmentManager(){
        return "admin/departmentManager/departmentManager";
    }

    @RequestMapping("/departmentAdd")
    public String toDepartmentAdd(){
        return "admin/departmentManager/departmentAdd";
    }

    @RequestMapping("/doctorManager")
    public String toDoctorManager(){
        return "admin/doctorManager/doctorManager";
    }

    @RequestMapping("/doctorAdd")
    public String toDoctorAdd(){
        return "admin/doctorManager/doctorAdd";
    }

    @RequestMapping("/toUpdateDoctor")
    public String toUpdateDoctor(@RequestParam Integer doctorId, Model model){
        model.addAttribute("doctorId",doctorId);
        return "admin/doctorManager/updateDoctor";
    }

    @RequestMapping("/registrationManager")
    public String toRegistrationManager(){
        return "admin/registrationManager/registrationManager";
    }

    @RequestMapping("/toRegistrationMore")
    public String toRegistrationMore(@RequestParam String registrationId, Model model){
        model.addAttribute("registrationId",registrationId);
        return "admin/registrationManager/registrationMore";
    }

    @RequestMapping("/recordManager")
    public String toRecordManager(){
        return "admin/recordManager/recordManager";
    }

    @RequestMapping("/toMedicalRecordMore")
    public String toMedicalRecordMore(@RequestParam String recordId, Model model){
        model.addAttribute("recordId",recordId);
        return "admin/recordManager/medicalRecordMore";
    }

    @RequestMapping("/prescriptionManager")
    public String toPrescriptionManager(){
        return "admin/prescriptionManager/prescriptionManager";
    }

    @RequestMapping("/toPrescriptionMore")
    public String toPrescriptionMore(@RequestParam String prescriptionId, Model model){
        model.addAttribute("prescriptionId",prescriptionId);
        return "admin/prescriptionManager/prescriptionMore";
    }

    @RequestMapping("/medicineManager")
    public String toMedicineManager(){
        return "admin/medicineManager/medicineManager";
    }

    @RequestMapping("/toUpdateMedicine")
    public String toUpdateMedicine(@RequestParam String drugId, Model model){
        model.addAttribute("drugId",drugId);
        return "admin/medicineManager/updateMedicine";
    }

    @RequestMapping("/toAddNewMedicine")
    public String toAddNewMedicine(){
        return "admin/medicineManager/addNewMedicine";
    }

    @RequestMapping("/medicineInLog")
    public String toMedicineInLog(){
        return "admin/medicineManager/medicineInLog";
    }

    @RequestMapping("/medicineOutLog")
    public String toMedicineOutLog(){
        return "admin/medicineManager/medicineOutLog";
    }

    @RequestMapping("/billManager")
    public String billManager(){
        return "admin/billManager/billManager";
    }

    @RequestMapping("/login")
    public String selectAdmin(@RequestParam String adminAccount, @RequestParam String adminPwd, Model model, HttpServletRequest request){
        System.out.println("adminLogin");
        // 对密码进行盐值加密
        // 盐值由用户账号进行转换而得
        ByteSource salt = ByteSource.Util.bytes(adminAccount);
        // 经过盐值 2 次加密后的密码
        String pwdWithMD5Salt = new Md5Hash(adminPwd,salt,2).toString();
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录请求
        UserToken token = new UserToken(adminAccount, pwdWithMD5Salt,"Admin");
        try{
            subject.login(token); // 执行登录方法，如果没有异常就说明 ok 了
            System.out.println("ok");
            Admin currentAdmin = adminService.selectAdminByAccount(adminAccount);
            request.getSession().setAttribute("currentAdmin",currentAdmin);
            return "admin/admin";
        }catch (UnknownAccountException e){ // 用户名不存在
            model.addAttribute("msg","账号或密码错误");
            System.out.println("管理员用户名错误");
            return  "login";
        }catch (IncorrectCredentialsException e2){ // 用户名不存在
            model.addAttribute("msg","账号或密码错误");
            System.out.println("管理员密码错误");
            return  "login";
        }
    }

    // 用于获取当前登录管理员信息
    @RequestMapping("/selectCurrentAdmin")
    @ResponseBody
    public Admin selectCurrentAdmin(HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute("currentAdmin");// 获取前，必须得先登录，不然获取结果为空
        Integer adminId = admin.getAdminId();
        Admin currentAdmin = adminService.selectAdminById(adminId);
        return currentAdmin;
    }

    @RequestMapping("/updateAdminById")
    @ResponseBody
    public String updateAdminById(Admin admin){
        try{
            adminService.updateAdminById(admin);
            return "update admin success";
        }catch (Exception e){
            e.printStackTrace();
            return "update admin fail";
        }
    }

    @RequestMapping("/selectPwdById")
    @ResponseBody
    public String selectPwdById(@RequestParam("adminId") Integer adminId,@RequestParam("pwd") String pwd, HttpServletRequest request){
        // 从数据库中获取旧密码
        String admin_pwd = adminService.selectPwdById(adminId);
        // 将新密码通过盐值加密后，与旧密码相比较
        Admin admin = (Admin) request.getSession().getAttribute("currentAdmin");
        String adminAccount = admin.getAdminAccount();
        ByteSource salt = ByteSource.Util.bytes(adminAccount); // 根据用户账号转换的盐值
        String pwdWithMD5Salt = new Md5Hash(pwd,salt,2).toString();
        if (pwdWithMD5Salt.equals(admin_pwd)){
            return "pwd right";
        }
        return "pwd error";
    }

    @RequestMapping("/updatePwdById")
    @ResponseBody
    public String updatePwdById(Admin admin, HttpServletRequest request){
        // 密码需过MD5盐值加密之后才能录入数据库中
        String adminAccount = ((Admin)request.getSession().getAttribute("currentAdmin")).getAdminAccount();// 获取当前登录用户的账号
        ByteSource salt = ByteSource.Util.bytes(adminAccount); // 用户对应的盐值
        String pwd = admin.getAdminPwd();
        String pwdWithMD5Salt = new Md5Hash(pwd,salt,2).toString(); // 盐值双加密
        admin.setAdminPwd(pwdWithMD5Salt);
        try{
            adminService.updatePwdById(admin);
            return "update pwd success";
        }catch (Exception e){
            e.printStackTrace();
            return "update pwd false";
        }
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

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user){
        try{
            String userAccount = user.getUserAccount();
            String userPwd = user.getUserPwd();
            if(userService.selectUserByAccount(userAccount)!=null){
                return "userAccount is exist";
            }else {
                // 对密码进行盐值加密
                // 盐值由用户账号进行转换而得
                ByteSource salt = ByteSource.Util.bytes(userAccount);
                // 经过盐值 2 次加密后的密码
                String pwdWithMD5Salt = new Md5Hash(userPwd,salt,2).toString();
                user.setUserPwd(pwdWithMD5Salt);
                userService.insertUser(user);
                return "insert user success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "insert user fail";
        }
    }

    @RequestMapping("/selectAllAdmin")
    @ResponseBody
    public PageInfo<Admin> selectAllAdmin(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Admin> admins = adminService.selectAllAdmin();
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);
        return pageInfo;
    }

    @RequestMapping("/selectAdminByKey")
    @ResponseBody
    public PageInfo<Admin> selectAdminByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Admin admin){
        PageHelper.startPage(pageNum,5);
        List<Admin> admins = adminService.selectAdminByKey(admin);
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);
        return pageInfo;
    }

    @RequestMapping("/insertAdmin")
    @ResponseBody
    public String insertAdmin(Admin admin) {
        try {
            String adminAccount = admin.getAdminAccount();
            String adminPwd = admin.getAdminPwd();
            if (adminService.selectAdminByAccount(adminAccount) != null) {
                return "adminAccount is exist";
            } else {
                // 对密码进行盐值加密
                // 盐值由用户账号进行转换而得
                ByteSource salt = ByteSource.Util.bytes(adminAccount);
                // 经过盐值 2 次加密后的密码
                String pwdWithMD5Salt = new Md5Hash(adminPwd, salt, 2).toString();
                admin.setAdminPwd(pwdWithMD5Salt);
                adminService.insertAdmin(admin);
                return "insert admin success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "insert admin fail";
        }
    }

    @RequestMapping("/insertDoctor")
    @ResponseBody
    public String insertDoctor(Doctor doctor){
        try{
            String doctorAccount = doctor.getDoctorAccount();
            String doctorPwd = doctor.getDoctorPwd();
            if(doctorService.selectDocByAccount(doctorAccount)!=null){
                return "doctorAccount is exist";
            }else {
                // 对密码进行盐值加密
                // 盐值由用户账号进行转换而得
                ByteSource salt = ByteSource.Util.bytes(doctorAccount);
                // 经过盐值 2 次加密后的密码
                String pwdWithMD5Salt = new Md5Hash(doctorPwd,salt,2).toString();
                doctor.setDoctorPwd(pwdWithMD5Salt);
                doctorService.insertDoctor(doctor);
                return "insert doc success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "insert doc fail";
        }
    }

    @RequestMapping("/updateDocById")
    @ResponseBody
    public String updateDocById(Doctor doctor){
        try {
            doctorService.updateDocById(doctor);
            return "update doctor success";
        }catch (Exception e){
            e.printStackTrace();
            return  "update doctor fail";
        }
    }

}
