package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.entity.Bill;
import com.zyj.hos.service.BillService;
import com.zyj.hos.vo.BillVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zyj
 * @date 2020/4/2 16:40
 */
@RestController
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping("/insertBill")
    public String insertBill(Bill bill){
        try{
            billService.insertBill(bill);
            return "insert bill success";
        }catch (Exception e){
            e.printStackTrace();
            return "insert bill success";
        }
    }

    @RequestMapping("/removeRegBill")
    public String removeRecBill(@RequestParam String registrationId){
        try{
            billService.removeRegBill(registrationId);
            return "remove reg success";
        }catch (Exception e){
            e.printStackTrace();
            return "remove reg fail";
        }
    }

    @RequestMapping("/selectBillByUserId")
    public List<Bill> selectBillByUserId(@RequestParam Integer userId){
        return billService.selectBillByUserId(userId);
    }

    @RequestMapping("/selectDetailsById")
    public String selectDetailsById(@RequestParam String billId){
        return billService.selectDetailsById(billId);
    }

    @RequestMapping("/selectAllBill")
    public PageInfo<Bill> selectAllBill(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Bill> bills = billService.selectAllBill();
        PageInfo<Bill> pageInfo = new PageInfo<>(bills);
        return pageInfo;
    }

    @RequestMapping("/selectBillByKey")
    public PageInfo<Bill> selectBillByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, BillVo billVo){
        PageHelper.startPage(pageNum,5);
        List<Bill> bills = billService.selectBillByKey(billVo);
        PageInfo<Bill> pageInfo = new PageInfo<>(bills);
        return pageInfo;
    }
}
