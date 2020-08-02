package com.zyj.hos.service.impl;

import com.zyj.hos.dao.DrugInMapper;
import com.zyj.hos.entity.DrugIn;
import com.zyj.hos.service.DrugInService;
import com.zyj.hos.vo.DrugInVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyj
 * @date 2020/4/1 17:08
 */
@Service
public class DrugInServiceImpl implements DrugInService {
    @Autowired
    private DrugInMapper drugInMapper;

    @Override
    public void insertDrugIn(DrugIn drugIn) {
        drugInMapper.insertDrugIn(drugIn);
    }

    @Override
    public List<DrugIn> selectAllDrugIn() {
        return drugInMapper.selectAllDrugIn();
    }

    @Override
    public List<DrugIn> selectDrugInByKey(DrugInVo drugInVo) {
        return drugInMapper.selectDrugInByKey(drugInVo);
    }

    @Override
    public DrugIn selectDrugInById(String inId) {
        return drugInMapper.selectDrugInById(inId);
    }
}
