package com.zyj.hos.service.impl;

import com.zyj.hos.dao.DrugListMapper;
import com.zyj.hos.entity.DrugList;
import com.zyj.hos.service.DrugListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugListServiceImpl implements DrugListService {

    @Autowired
    private DrugListMapper drugListMapper;

    @Override
    public void insertDrugList(DrugList drugList) {
        drugListMapper.insertDrugList(drugList);
    }

    @Override
    public List<DrugList> selectDrugByPreId(String prescriptionId) {
        return drugListMapper.selectDrugByPreId(prescriptionId);
    }

    @Override
    public List<DrugList> selectTimeOutDrug(List<String> prescriptionIds) {
        return drugListMapper.selectTimeOutDrug(prescriptionIds);
    }
}
