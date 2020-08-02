package com.zyj.hos.controller;

import com.zyj.hos.entity.Patient;
import com.zyj.hos.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class PatientController {
    @Resource
    private PatientService patientService;

    @RequestMapping("/insertPatient")
    @ResponseBody
    public String insertPatient(Patient patient){
        try{
            String medicalCard = patient.getMedicalCard();
            if(patientService.selectCard(medicalCard)!=null){ // 判断病人是否存在
                // 将病人就诊类型转换为复诊
                patientService.updateTypeByCard(medicalCard);
                System.out.println("病人信息已存在，则自动将病人类型转为复诊");
                return "patient is exist";
            }else {
                patientService.insertPatient(patient);
                System.out.println("病人信息插入成功");
                return "success";
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error");
            return "error";
        }
    }

    @RequestMapping("/updatePatById")
    @ResponseBody
    public String updatePatById(Patient patient){
        try{
            patientService.updatePatById(patient);
            return "update patient success";
        }catch(Exception e){
            e.printStackTrace();
            return "update patient error";
        }
    }

    @RequestMapping("/selectCard")
    @ResponseBody
    public Patient selectCard(@RequestParam String medicalCard){
        try{
            return patientService.selectCard(medicalCard);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("发生未知错误，请稍后再试");
            return null;
        }
    }

    @RequestMapping("/selectPatByRecId")
    @ResponseBody
    public Patient selectPatByRecId(@RequestParam String recordId){
        try{
            return patientService.selectPatByRecId(recordId);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("发生未知错误，请稍后再试");
            return null;
        }
    }
}
