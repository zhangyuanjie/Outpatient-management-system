package com.zyj.hos.service;

import com.zyj.hos.dao.DrugMapper;
import com.zyj.hos.entity.Drug;
import com.zyj.hos.entity.DrugList;

import java.util.List;

public interface DrugService extends DrugMapper {
    public List<Drug> selectAllDrug();
    public Drug selectDrugById(Integer drugId);
    public Integer selectStockById(Integer drugId);
    public List<String> selectDrugType();
    public List<Drug> selectDrugByKey(Drug drug);
    public void updateDrugById(Drug drug);
    public void insertDrug(Drug drug);
    public void updateStockById(Drug drug);
    public void returnDrug(DrugList drugList);
}
