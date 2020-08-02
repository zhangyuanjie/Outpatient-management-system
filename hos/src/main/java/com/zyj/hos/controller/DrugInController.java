package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.entity.Diagnostic;
import com.zyj.hos.entity.DrugIn;
import com.zyj.hos.service.DrugInService;
import com.zyj.hos.vo.DrugInVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyj
 * @date 2020/4/1 17:09
 */
@RestController
public class DrugInController {
    @Resource
    private DrugInService drugInService;

    @RequestMapping("/insertDrugIn")
    public String insertDrugIn(DrugIn drugIn){
        try{
            drugInService.insertDrugIn(drugIn);
            return "insert in success";
        }catch (Exception e){
            e.printStackTrace();
            return "insert in fail";
        }
    }

    @RequestMapping("/selectAllDrugIn")
    public PageInfo<DrugIn> selectAllDrugIn(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<DrugIn> drugIns = drugInService.selectAllDrugIn();
        PageInfo<DrugIn> pageInfo = new PageInfo<>(drugIns);
        return pageInfo;
    }

    @RequestMapping("/selectDrugInByKey")
    public PageInfo<DrugIn> selectDrugInByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, DrugInVo drugInVo){
        PageHelper.startPage(pageNum,5);
        List<DrugIn> drugIns = drugInService.selectDrugInByKey(drugInVo);
        PageInfo<DrugIn> pageInfo = new PageInfo<>(drugIns);
        return pageInfo;
    }

    @RequestMapping("/selectDrugInById")
    public DrugIn selectDrugById(@RequestParam String inId){
        return drugInService.selectDrugInById(inId);
    }
}
