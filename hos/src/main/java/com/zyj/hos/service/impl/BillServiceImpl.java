package com.zyj.hos.service.impl;

import com.zyj.hos.dao.BillMapper;
import com.zyj.hos.entity.Bill;
import com.zyj.hos.service.BillService;
import com.zyj.hos.vo.BillVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyj
 * @date 2020/4/2 16:38
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;

    @Override
    public void insertBill(Bill bill) {
        billMapper.insertBill(bill);
    }

    @Override
    public void removeRegBill(String registrationId) {
        billMapper.removeRegBill(registrationId);
    }

    @Override
    public List<Bill> selectBillByUserId(Integer userId) {
        return billMapper.selectBillByUserId(userId);
    }

    @Override
    public String selectDetailsById(String billId) {
        return billMapper.selectDetailsById(billId);
    }

    @Override
    public List<Bill> selectAllBill() {
        return billMapper.selectAllBill();
    }

    @Override
    public List<Bill> selectBillByKey(BillVo billVo) {
        return billMapper.selectBillByKey(billVo);
    }
}
