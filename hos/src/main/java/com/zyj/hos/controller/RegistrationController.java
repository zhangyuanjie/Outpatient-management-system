package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.entity.Registration;
import com.zyj.hos.entity.User;
import com.zyj.hos.service.RegistrationService;
import com.zyj.hos.vo.RegistrationVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegistrationController {
    @Resource
    private RegistrationService registrationService;

    @RequestMapping("/insertRegistration")
    @ResponseBody
    public String insertRegistration(Registration registration){
        try{
            registrationService.insertRegistration(registration);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/selectNowReg")
    @ResponseBody
    public List<Registration> selectNowReg(HttpServletRequest request){
        // 获取当前登录用户对象
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        try{
            // 根据当前登录对象获取该对象的挂号信息
            return registrationService.selectNowReg(currentUser.getUserId());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("未登录");
            return null;
        }
    }

    @RequestMapping("/selectOldReg")
    @ResponseBody
    public List<Registration> selectOldReg(HttpServletRequest request){
        // 获取当前登录用户对象
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        try{
            // 根据当前登录对象获取该对象的挂号信息
            return registrationService.selectOldReg(currentUser.getUserId());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("未登录");
            return null;
        }
    }

    @RequestMapping("/selectRegMore")
    @ResponseBody
    public Registration selectRegMore(@RequestParam String registrationId){
        return registrationService.selectRegMore(registrationId);
    }

    @RequestMapping("/toRegMore")
    public String toRegMore(@RequestParam String registrationId, Model model){
        model.addAttribute("registrationId",registrationId);
        return "/user/registration/registrationMore";
    }

    @RequestMapping("/deleteRegById")
    @ResponseBody
    public String deleteRegById(@RequestParam String registrationId){
        try{
            registrationService.deleteRegById(registrationId);
            return "delete success";
        }catch (Exception e){
            e.printStackTrace();
            return "delete false";
        }
    }

    @RequestMapping("/updateRegById")
    @ResponseBody
    public String updateRegById(Registration registration){
        try{
            registrationService.updateRegById(registration);
            return "update reg success";
        }catch (Exception e){
            e.printStackTrace();
            return "update reg false";
        }
    }

    @RequestMapping("/selectRegByRegId")
    @ResponseBody
    public String selectRegByRegId(@RequestParam String registrationId){
        try{
            Registration registration = registrationService.selectRegByRegId(registrationId);
            if(registration!=null){
                return "rec is exist";
            }else {
                return "rec is not exist";
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("发生未知错误，请稍后再试");
            return "error";
        }
    }

    /*
     * @Author zhangyuanjie
     * @Description //TODO 
     * @Date 14:22 2020/3/27
     * @Param [registrationVo]
     * @return com.zyj.hos.entity.Registration
    **/
    @RequestMapping("/selectRegByKey")
    @ResponseBody
    public PageInfo<Registration> selectRegByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RegistrationVo registrationVo){
        PageHelper.startPage(pageNum,5);
        List<Registration> registrations = registrationService.selectRegByKey(registrationVo);
        PageInfo<Registration> pageInfo = new PageInfo<>(registrations);
        return pageInfo;
    }

    @RequestMapping("/selectRegPatByKey")
    @ResponseBody
    public PageInfo<Registration> selectRegPatByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RegistrationVo registrationVo){
        PageHelper.startPage(pageNum,5);
        List<Registration> registrations = registrationService.selectRegPatByKey(registrationVo);
        PageInfo<Registration> pageInfo = new PageInfo<>(registrations);
        return pageInfo;
    }

    @RequestMapping("/updateStatusById")
    @ResponseBody
    public String updateStatusById(@RequestParam String registrationId){
        try {
            registrationService.updateStatusById(registrationId);
            return "update reg success";
        }catch (Exception e){
            e.printStackTrace();
            return "update reg fail";
        }
    }

    @RequestMapping("/selectAllReg")
    @ResponseBody
    public PageInfo<Registration> selectAllReg(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Registration> registrations = registrationService.selectAllReg();
        PageInfo<Registration> pageInfo = new PageInfo<>(registrations);
        return pageInfo;
    }

    @RequestMapping("/selectRegMoreByKey")
    @ResponseBody
    public PageInfo<Registration> selectRegMoreByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RegistrationVo registrationVo){
        PageHelper.startPage(pageNum,5);
        List<Registration> registrations = registrationService.selectRegMoreByKey(registrationVo);
        PageInfo<Registration> pageInfo = new PageInfo<>(registrations);
        return pageInfo;
    }
}
