package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.entity.Drug;
import com.zyj.hos.entity.DrugList;
import com.zyj.hos.entity.DrugOut;
import com.zyj.hos.service.DrugListService;
import com.zyj.hos.service.DrugOutService;
import com.zyj.hos.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DrugController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private DrugListService drugListService;
    @Autowired
    private DrugOutService drugOutService;

    @RequestMapping("/selectAllDrug")
    @ResponseBody
    public PageInfo<Drug> selectAllDrug(@RequestParam(defaultValue = "1",value="pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Drug> drugs = drugService.selectAllDrug();
        PageInfo<Drug> pageInfo = new PageInfo<Drug>(drugs);
        return pageInfo;
    }

    @RequestMapping("/selectDrugById")
    @ResponseBody
    public Drug selectDrugById(@RequestParam Integer drugId){
        return drugService.selectDrugById(drugId);
    }

    @RequestMapping("/insertDrugList")
    @ResponseBody
    public String insertDrugList(DrugList drugList, @RequestParam String outId){
        Integer drugId = drugList.getDrugId();
        Integer drugNum = drugList.getDrugNum();
        Integer drugStock = drugService.selectStockById(drugId);
        Integer lastStock = 0;
        DrugOut drugOut = new DrugOut();
        drugOut.setOutId(outId);
        drugOut.setDrugId(drugId);
        drugOut.setOutSum(drugNum);
        if (drugNum > drugStock){
            return "stock is not enough";
        }else {
            lastStock = drugStock - drugNum;
            Drug drug = new Drug();
            drug.setDrugId(drugId);
            drug.setDrugStock(lastStock);
            drugListService.insertDrugList(drugList);
            drugService.updateStockById(drug);
            drugOutService.insertDrugOut(drugOut);
            return "insrt drugList success";
        }
    }

    @RequestMapping("/selectDrugType")
    @ResponseBody
    public List<String> selectDrugType(){
        return drugService.selectDrugType();
    }

    @RequestMapping("/selectDrugByKey")
    @ResponseBody
    public PageInfo<Drug> selectDrugByKey(@RequestParam(defaultValue = "1",value="pageNum") Integer pageNum, Drug drug){
        PageHelper.startPage(pageNum,5);
        List<Drug> drugs = drugService.selectDrugByKey(drug);
        PageInfo<Drug> pageInfo = new PageInfo<Drug>(drugs);
        return pageInfo;
    }

    @RequestMapping("/selectDrugByPreId")
    @ResponseBody
    public List<DrugList> selectDrugByPreId(@RequestParam String prescriptionId){
        return drugListService.selectDrugByPreId(prescriptionId);
    }

    @RequestMapping("/updateDrugById")
    @ResponseBody
    public String updateDrugById(Drug drug){
        try {
            drugService.updateDrugById(drug);
            return "update drug success";
        }catch (Exception e){
            e.printStackTrace();
            return "update drug fail";
        }
    }

    @RequestMapping("/insertDrug")
    @ResponseBody
    public String insertDrug(Drug drug, HttpServletRequest request){
        try {
            drugService.insertDrug(drug);
            String drugId = drug.getDrugId().toString();
            return drugId;// 将新入库的药品id传至前端，以便进行入库记录的插入
        }catch (Exception e){
            e.printStackTrace();
            return "insert drug fail";
        }
    }

    @RequestMapping("/updateStockById")
    @ResponseBody
    public String updateStockById(Drug drug){
        try {
            drugService.updateStockById(drug);
            return "update drug stock success";
        }catch (Exception e){
            e.printStackTrace();
            return "update drug stock fail";
        }
    }
}
