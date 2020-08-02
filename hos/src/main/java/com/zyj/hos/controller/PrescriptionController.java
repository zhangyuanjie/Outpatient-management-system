package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.entity.Drug;
import com.zyj.hos.entity.DrugIn;
import com.zyj.hos.entity.DrugList;
import com.zyj.hos.entity.Prescription;
import com.zyj.hos.service.DrugInService;
import com.zyj.hos.service.DrugListService;
import com.zyj.hos.service.DrugService;
import com.zyj.hos.service.PrescriptionService;
import com.zyj.hos.vo.PrescriptionVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PrescriptionController {
    @Resource
    private PrescriptionService prescriptionService;

    @Resource
    private DrugListService drugListService;

    @Resource
    private DrugService drugService;

    @Resource
    private DrugInService drugInService;

    @RequestMapping("/insertPrescription")
    @ResponseBody
    public String insertPrescription(Prescription prescription){
        try {
            prescriptionService.insertPre(prescription);
            return "insert pre success";
        }catch (Exception e){
            e.printStackTrace();
            return "insert pre fail";
        }
    }

    @RequestMapping("/selectPreById")
    @ResponseBody
    public String selectPreById(@RequestParam String prescriptionId){
        if(prescriptionService.selectPreById(prescriptionId)!=null){
            return "pre is exist";
        }else {
            return "pre is not exist";
        }
    }

    @RequestMapping("/selectPrePatByDocId")
    @ResponseBody
    public PageInfo<Prescription> selectPrePatByDocId(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Integer doctorId){
        PageHelper.startPage(pageNum,5);
        List<Prescription> prescriptions = prescriptionService.selectPrePatByDocId(doctorId);
        PageInfo<Prescription> pageInfo = new PageInfo<>(prescriptions);
        return pageInfo;
    }

    @RequestMapping("/selectPrePatByKey")
    @ResponseBody
    public PageInfo<Prescription> selectPrePatByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, PrescriptionVo prescriptionVo){
        PageHelper.startPage(pageNum,5);
        List<Prescription> prescriptions = prescriptionService.selectPrePatByKey(prescriptionVo);
        PageInfo<Prescription> pageInfo = new PageInfo<>(prescriptions);
        return pageInfo;
    }

    @RequestMapping("/selectPrePatByPreId")
    @ResponseBody
    public Prescription selectPrePatByPreId(@RequestParam String prescriptionId){
        return prescriptionService.selectPrePatByPreId(prescriptionId);
    }

    @RequestMapping("/selectPrePatByUserId")
    @ResponseBody
    public List<Prescription> selectPrePatByUserId(@RequestParam Integer userId){
        return prescriptionService.selectPrePatByUserId(userId);
    }

    @RequestMapping("/selectAllPre")
    @ResponseBody
    public PageInfo<Prescription> selectAllPre(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Prescription> prescriptions = prescriptionService.selectAllPre();
        PageInfo<Prescription> pageInfo = new PageInfo<>(prescriptions);
        return pageInfo;
    }

    @RequestMapping("/updatePrePaid")
    @ResponseBody
    public String updatePrePaid(@RequestParam String prescriptionId){
        try{
            prescriptionService.updatePrePaid(prescriptionId);
            return "update pre success";
        }catch (Exception e){
            e.printStackTrace();
            return "update pre fail";
        }
    }

    @RequestMapping("/updateTimeOutPre")
    @ResponseBody
    public String updateTimeOutPre(@RequestParam String inId){
        List<String> preIds = prescriptionService.selectTimeOutPre();
        if(preIds.size()<=0){
            return "no timeOut pre";
        }else {
            prescriptionService.updateTimeOutPre();
            List<DrugList> drugLists = drugListService.selectTimeOutDrug(preIds);
            Integer drugId = 0;
            Integer num = 0;
            DrugList drugList = new DrugList();
            DrugIn drugIn = new DrugIn();
            for(int i =0;i<drugLists.size();i++){
                drugId = drugLists.get(i).getDrugId();
                num = drugLists.get(i).getDrugNum();
                drugList.setDrugId(drugId);
                drugList.setDrugNum(num);
                drugIn.setInId(inId + "" + i);
                drugIn.setDrugId(drugId);
                drugIn.setInSum(num);
                drugIn.setAdminId(1); //设置处方失效返回数据库时，默认是编号为 1 的管理员进行操作
                drugService.returnDrug(drugList); // 将过期失效的处方内的药品信息返回至数据库
                drugInService.insertDrugIn(drugIn);
            }
            return "预期未缴费的处方已经处理";
        }
    }
}
