package com.zyj.hos.service.impl;

import com.zyj.hos.dao.DrugOutMapper;
import com.zyj.hos.entity.DrugOut;
import com.zyj.hos.service.DrugOutService;
import com.zyj.hos.vo.DrugOutVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyj
 * @date 2020/4/1 17:08
 */
@Service
public class DrugOutServiceImpl implements DrugOutService {
    @Autowired
    private DrugOutMapper drugOutMapper;
    @Override
    public void insertDrugOut(DrugOut drugOut) {
        drugOutMapper.insertDrugOut(drugOut);
    }

    @Override
    public List<DrugOut> selectAllDrugOut() {
        return drugOutMapper.selectAllDrugOut();
    }

    @Override
    public List<DrugOut> selectDrugOutByKey(DrugOutVo drugOutVo) {
        return drugOutMapper.selectDrugOutByKey(drugOutVo);
    }
}
