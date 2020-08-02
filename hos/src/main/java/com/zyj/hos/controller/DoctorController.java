package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.config.shiroConfig.UserToken;
import com.zyj.hos.entity.Doctor;
import com.zyj.hos.entity.Registration;
import com.zyj.hos.service.DoctorService;
import com.zyj.hos.service.RegistrationService;
import com.zyj.hos.vo.DoctorVo;
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
public class DoctorController {

    @Resource
    private DoctorService doctorService;
    @Resource
    private RegistrationService registrationService;

    @RequestMapping("/doctor/login")
    public String selectDoctor(@RequestParam String doctorAccount, @RequestParam String doctorPwd, Model model, HttpServletRequest request){
        System.out.println("DoctorLogin");
        // 对密码进行盐值加密
        // 盐值由用户账号进行转换而得
        ByteSource salt = ByteSource.Util.bytes(doctorAccount);
        // 经过盐值 2 次加密后的密码
        String pwdWithMD5Salt = new Md5Hash(doctorPwd,salt,2).toString();
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录请求
        UserToken token = new UserToken(doctorAccount, pwdWithMD5Salt,"Doctor");
        try{
            subject.login(token); // 执行登录方法，如果没有异常就说明 ok 了
            System.out.println("ok");
            Doctor currentDoctor = doctorService.selectDoctorByAccount(doctorAccount);
            request.getSession().setAttribute("currentDoctor", currentDoctor);
            return "doctor/doctor";
        }catch (UnknownAccountException e){ // 用户名不存在
            model.addAttribute("msg","账号或密码错误");
            System.out.println("医生账号错误");
            return  "login";
        }catch (IncorrectCredentialsException e2){ // 用户名不存在
            model.addAttribute("msg","账号或密码错误");
            System.out.println("医生密码错误");
            return  "login";
        }
    }

    // 用于获取当前登录医生信息
    @RequestMapping("/doctor/selectCurrentDoctor")
    @ResponseBody
    public Doctor selectCurrentDoctor(HttpServletRequest request){
        Doctor Doctor = (Doctor)request.getSession().getAttribute("currentDoctor");// 获取前，必须得先登录，不然获取结果为空
        Integer doctorId = Doctor.getDoctorId();
        Doctor currentDoctor = doctorService.selectDoctorById(doctorId);
        return currentDoctor;
    }

    @RequestMapping("/doctor/doctorIndex")
    public String toDoctorIndex(){
        return "doctor/doctorIndex";
    }

    @RequestMapping("/doctor/updateSelf")
    public String toUpdateSelf(){
        return "doctor/doctorSelf/updateSelf";
    }

    @RequestMapping("/doctor/updatePwd")
    public String toUpdatePwd(){
        return "doctor/doctorSelf/updatePwd";
    }

    @RequestMapping("/doctor/myDiagnostic")
    public String toMyDiagnostic(){
        return "doctor/myPatient/myDiagnostic";
    }

    @RequestMapping("/doctor/myPrescription")
    public String toMyPrescription(){
        return "doctor/myPatient/myPrescription";
    }

    @RequestMapping("/doctor/toPrescriptionDetails")
    public String toPrescriptionDetails(@RequestParam String prescriptionId, Model model){
        model.addAttribute("prescriptionId",prescriptionId);
        return "doctor/myPatient/prescriptionDetails";
    }

    @RequestMapping("/doctor/toMedicalRecordDetails")
    public String toMedicalRecordDetails(Model model, @RequestParam String recordId){
        model.addAttribute("recordId", recordId);
        return "doctor/myPatient/medicalRecordDetails";
    }

    @RequestMapping("/doctor/myPatient")
    public String toMyPatient(){
        return "doctor/myPatient/myPatient";
    }

    @RequestMapping("/doctor/toWriteMedical")
    public String toWriteMedical(Model model, @RequestParam String registrationId){
        model.addAttribute("registrationId", registrationId);
        System.out.println(registrationId);
        return "doctor/myPatient/writeMedical";
    }

    @RequestMapping("/doctor/toWritePrescription")
    public String toWritePrescription(Model model, @RequestParam String recordId, @RequestParam String registrationId){
        model.addAttribute("recordId", recordId);
        model.addAttribute("registrationId", registrationId);
        System.out.println(recordId);
        return "doctor/myPatient/writePrescription";
    }

    @RequestMapping("/doctor/addDiagnostic")
    @ResponseBody
    public String addDiagnostic(){
        System.out.println("增加一段诊断结果");
        return "addDiagnostic";
    }

    @RequestMapping("/doctor/medicalRecord")
    public String toMedicalRecord(){
        return "myPrescription";
    }

    @RequestMapping("/doctor/departmentManager")
    public String toDepartmentManager(){
        return "doctor/msgSearch/departmentManager";
    }

    @RequestMapping("/doctor/doctorManager")
    public String toDoctorManager(){
        return "doctor/msgSearch/doctorManager";
    }

    @RequestMapping("/doctor/medicineManager")
    public String toMedicineManager(){
        return "doctor/msgSearch/medicineManager";
    }

    @RequestMapping("/doctor/registrationManager")
    public String toRegistrationManager(){
        return "doctor/registration/registrationManager";
    }

    @RequestMapping("/doctor/toRegistrationMore")
    public String toRegistrationMore(@RequestParam String registrationId, Model model){
        model.addAttribute("registrationId",registrationId);
        System.out.println(registrationId);
        return "doctor/registration/registrationMore";
    }

    @RequestMapping("/selectDoctorByDepId")
    @ResponseBody
    public PageInfo<Doctor> selectDoctorByDepId(@RequestParam(defaultValue = "1",value="pageNum") Integer pageNum,Integer departmentId){
        PageHelper.startPage(pageNum,5);
        List<Doctor> doctors = doctorService.selectDoctorByDepId(departmentId);
        PageInfo<Doctor> pageInfo = new PageInfo<Doctor>(doctors);
        return pageInfo;
    }

    @RequestMapping("/selectDoctorById")
    @ResponseBody
    public Doctor selectDoctorById(Integer doctorId){
        return doctorService.selectDoctorById(doctorId);
    }

    @RequestMapping("/selectDoctorDepById")
    @ResponseBody
    public Doctor selectDoctorDepById(Integer doctorId){
        return doctorService.selectDoctorDepById(doctorId);
    }

    @RequestMapping("/selectDoctorByKey")
    @ResponseBody
    public PageInfo<Doctor> selectDoctorByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, DoctorVo doctorVo){
        PageHelper.startPage(pageNum,5);
        List<Doctor> doctors = doctorService.selectDoctorByKey(doctorVo);
        PageInfo<Doctor> pageInfo = new PageInfo<>(doctors);
        return pageInfo;
    }

    @RequestMapping("/selectAllDoctor")
    @ResponseBody
    public PageInfo<Doctor> selectAllDoctor(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Doctor> doctors = doctorService.selectAllDoctor();
        PageInfo<Doctor> pageInfo = new PageInfo<>(doctors);
        return pageInfo;
    }

    @RequestMapping("/doctor/updateDoctorById")
    @ResponseBody
    public String updateDoctorById(Doctor doctor){
        try{
            doctorService.updateDoctorById(doctor);
            return "update doctor success";
        }catch (Exception e){
            e.printStackTrace();
            return "update doctor fail";
        }
    }

    @RequestMapping("/doctor/selectPwdById")
    @ResponseBody
    public String selectPwdById(@RequestParam("doctorId") Integer doctorId,@RequestParam("pwd") String pwd, HttpServletRequest request){
        // 从数据库中获取旧密码
        String doctor_pwd = doctorService.selectPwdById(doctorId);
        // 将新密码通过盐值加密后，与旧密码相比较
        Doctor doctor = (Doctor) request.getSession().getAttribute("currentDoctor");
        String doctorAccount = doctor.getDoctorAccount();
        ByteSource salt = ByteSource.Util.bytes(doctorAccount); // 根据用户账号转换的盐值
        String pwdWithMD5Salt = new Md5Hash(pwd,salt,2).toString();
        if (pwdWithMD5Salt.equals(doctor_pwd)){
            return "pwd right";
        }
        return "pwd error";
    }

    @RequestMapping("/doctor/updatePwdById")
    @ResponseBody
    public String updatePwdById(Doctor doctor, HttpServletRequest request){
        // 密码需过MD5盐值加密之后才能录入数据库中
        String doctorAccount = ((Doctor)request.getSession().getAttribute("currentDoctor")).getDoctorAccount();// 获取当前登录用户的账号
        ByteSource salt = ByteSource.Util.bytes(doctorAccount); // 用户对应的盐值
        String pwd = doctor.getDoctorPwd();
        String pwdWithMD5Salt = new Md5Hash(pwd,salt,2).toString();
        doctor.setDoctorPwd(pwdWithMD5Salt);
        try{
            doctorService.updatePwdById(doctor);
            return "update pwd success";
        }catch (Exception e){
            e.printStackTrace();
            return "update pwd false";
        }
    }

    // 根据 doctorId 获取预约的挂号信息
    @RequestMapping("/selectRegByDocId")
    @ResponseBody
    public PageInfo<Registration> selectRegByDocId(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @RequestParam Integer doctorId){
        PageHelper.startPage(pageNum,5);
        List<Registration> registrations = registrationService.selectRegByDocId(doctorId);
        PageInfo<Registration> pageInfo = new PageInfo<>(registrations);
        return pageInfo;
    }

    // 接受预约
    @RequestMapping("/doctor/acceptRegById")
    @ResponseBody
    public String acceptRegById(@RequestParam String registrationId){
        try{
            registrationService.acceptRegById(registrationId);
            return "accept reg success";
        }catch (Exception e){
            e.printStackTrace();
            return "accept reg false";
        }
    }

    // 根据 doctorId 获取病人信息
    @RequestMapping("/selectPatByDocId")
    @ResponseBody
    public PageInfo<Registration> selectPatByDocId(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @RequestParam Integer doctorId){
        PageHelper.startPage(pageNum,5);
        List<Registration> registrations = registrationService.selectPatByDocId(doctorId);
        PageInfo<Registration> pageInfo = new PageInfo<>(registrations);
        return pageInfo;
    }

    // 根据挂号编号获取对应的病人详细信息
    @RequestMapping("/selectPatByRegId")
    @ResponseBody
    public Registration selectPatByRegId(@RequestParam String registrationId){
        try{
            return registrationService.selectPatByRegId(registrationId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
