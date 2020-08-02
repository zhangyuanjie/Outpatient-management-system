package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.entity.DrugOut;
import com.zyj.hos.service.DrugOutService;
import com.zyj.hos.vo.DrugOutVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyj
 * @date 2020/4/1 17:09
 */
@RestController
public class DrugOutController {
    @Resource
    private DrugOutService drugOutService;

    @RequestMapping("/insertDrugOut")
    public String insertDrugOut(DrugOut drugOut){
        try{
            drugOutService.insertDrugOut(drugOut);
            return "insert out success";
        }catch (Exception e){
            e.printStackTrace();
            return "insert out fail";
        }
    }

    @RequestMapping("/selectAllDrugOut")
    public PageInfo<DrugOut> selectAllDrugOut(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<DrugOut> drugOuts = drugOutService.selectAllDrugOut();
        PageInfo<DrugOut> pageOutfo = new PageInfo<>(drugOuts);
        return pageOutfo;
    }

    @RequestMapping("/selectDrugOutByKey")
    public PageInfo<DrugOut> selectDrugOutByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, DrugOutVo drugOutVo){
        PageHelper.startPage(pageNum,5);
        List<DrugOut> drugOuts = drugOutService.selectDrugOutByKey(drugOutVo);
        PageInfo<DrugOut> pageOutfo = new PageInfo<>(drugOuts);
        return pageOutfo;
    }

}
