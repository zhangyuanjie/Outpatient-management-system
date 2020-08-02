package com.zyj.hos.dao;

import com.zyj.hos.entity.DrugList;

import java.util.List;

public interface DrugListMapper {
    public void insertDrugList(DrugList drugList);
    public List<DrugList> selectDrugByPreId(String prescriptionId);
    public List<DrugList> selectTimeOutDrug(List<String> prescriptionIds);
}
