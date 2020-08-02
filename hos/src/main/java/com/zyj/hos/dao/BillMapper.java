package com.zyj.hos.dao;

import com.zyj.hos.entity.Bill;
import com.zyj.hos.vo.BillVo;

import java.util.List;

/**
 * @author zyj
 * @date 2020/4/2 16:37
 */
public interface BillMapper {
    public void insertBill(Bill bill);
    public void removeRegBill(String registrationId);
    // 根据用户查询近一个月内的所有账单
    public List<Bill> selectBillByUserId(Integer userId);
    public String selectDetailsById(String billId);
    public List<Bill> selectAllBill();
    public List<Bill> selectBillByKey(BillVo billVo);
}
