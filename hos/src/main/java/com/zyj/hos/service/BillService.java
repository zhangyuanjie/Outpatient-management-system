package com.zyj.hos.service;

import com.zyj.hos.dao.BillMapper;
import com.zyj.hos.entity.Bill;
import com.zyj.hos.vo.BillVo;

import java.util.List;

/**
 * @author zyj
 * @date 2020/4/2 16:38
 */
public interface BillService extends BillMapper {
    public void insertBill(Bill bill);
    public void removeRegBill(String registrationId);
    public List<Bill> selectBillByUserId(Integer userId);
    public String selectDetailsById(String billId);
    public List<Bill> selectAllBill();
    public List<Bill> selectBillByKey(BillVo billVo);
}
