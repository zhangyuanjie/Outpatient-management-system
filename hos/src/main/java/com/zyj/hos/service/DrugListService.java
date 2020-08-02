package com.zyj.hos.service;

import com.zyj.hos.dao.DrugListMapper;
import com.zyj.hos.entity.DrugList;

import java.util.List;

public interface DrugListService extends DrugListMapper {
    public void insertDrugList(DrugList drugList);
    public List<DrugList> selectDrugByPreId(String prescriptionId);
    public List<DrugList> selectTimeOutDrug(List<String> prescriptionIds);
}
