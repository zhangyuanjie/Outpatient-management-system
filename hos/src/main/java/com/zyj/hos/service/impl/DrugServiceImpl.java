package com.zyj.hos.service.impl;

import com.zyj.hos.dao.DrugMapper;
import com.zyj.hos.entity.Drug;
import com.zyj.hos.entity.DrugList;
import com.zyj.hos.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<Drug> selectAllDrug() {
        return drugMapper.selectAllDrug();
    }

    @Override
    public Drug selectDrugById(Integer drugId) {
        return drugMapper.selectDrugById(drugId);
    }

    @Override
    public Integer selectStockById(Integer drugId) {
        return drugMapper.selectStockById(drugId);
    }

    @Override
    public List<String> selectDrugType() {
        return drugMapper.selectDrugType();
    }

    @Override
    public List<Drug> selectDrugByKey(Drug drug) {
        return drugMapper.selectDrugByKey(drug);
    }

    @Override
    public void updateDrugById(Drug drug) {
        drugMapper.updateDrugById(drug);
    }

    @Override
    public void insertDrug(Drug drug) {
        drugMapper.insertDrug(drug);
    }

    @Override
    public void updateStockById(Drug drug) {
        drugMapper.updateStockById(drug);
    }

    @Override
    public void returnDrug(DrugList drugList) {
        drugMapper.returnDrug(drugList);
    }
}
