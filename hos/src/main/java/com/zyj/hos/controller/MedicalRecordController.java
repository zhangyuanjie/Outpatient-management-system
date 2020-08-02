package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.entity.MedicalRecord;
import com.zyj.hos.entity.Registration;
import com.zyj.hos.service.MedicalRecordService;
import com.zyj.hos.vo.MedicalRecordVo;
import com.zyj.hos.vo.RegistrationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @RequestMapping("/selectRecAndDiaById")
    @ResponseBody
    public MedicalRecord selectRecAndDiaById(@RequestParam String recordId){
        return medicalRecordService.selectRecAndDiaById(recordId);
    }

    @RequestMapping("/selectRecByCard")
    @ResponseBody
    public String selectRecByCard(@RequestParam String medicalCard){
        try{
            MedicalRecord medicalRecord = medicalRecordService.selectRecByCard(medicalCard);
            if(medicalRecord!=null){
                return medicalRecord.getRecordId();
            }else {
                return "Record is not exist";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/selectRecById")
    @ResponseBody
    public String selectRecById(@RequestParam String recordId){
        try{
            MedicalRecord medicalRecord = medicalRecordService.selectRecById(recordId);
            if(medicalRecord!=null){
                return "Record is exist";
            }else {
                return "Record is not exist";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/insertRec")
    @ResponseBody
    public String insertRec(MedicalRecord medicalRecord){
        try{
            String medicalCard = medicalRecord.getMedicalCard();
            MedicalRecord medicalRecord1 = medicalRecordService.selectRecByCard(medicalCard);
            if(medicalRecord1!=null){
                return "rec is exist";
            }else {
                medicalRecordService.insertRec(medicalRecord);
                return "insert rec success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/selectRecByRecId")
    @ResponseBody
    public MedicalRecord selectRecByRecId(@RequestParam String recordId){
        return medicalRecordService.selectRecById(recordId);
    }

    @RequestMapping("/selectRecByUserId")
    @ResponseBody
    public List<MedicalRecord> selectRecByUserId(@RequestParam Integer userId){
        return medicalRecordService.selectRecByUserId(userId);
    }

    @RequestMapping("/selectAllRec")
    @ResponseBody
    public PageInfo<MedicalRecord> selectAllRec(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<MedicalRecord> medicalRecords = medicalRecordService.selectAllRec();
        PageInfo<MedicalRecord> pageInfo = new PageInfo<>(medicalRecords);
        return pageInfo;
    }

    @RequestMapping("/selectRecByKey")
    @ResponseBody
    public PageInfo<MedicalRecord> selectRecByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, MedicalRecordVo medicalRecordVo){
        PageHelper.startPage(pageNum,5);
        List<MedicalRecord> medicalRecords = medicalRecordService.selectRecByKey(medicalRecordVo);
        PageInfo<MedicalRecord> pageInfo = new PageInfo<>(medicalRecords);
        return pageInfo;
    }
}
