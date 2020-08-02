package com.zyj.hos.service;

import com.zyj.hos.dao.DrugInMapper;
import com.zyj.hos.entity.DrugIn;
import com.zyj.hos.vo.DrugInVo;

import java.util.List;

/**
 * @author zyj
 * @date 2020/4/1 17:07
 */
public interface DrugInService extends DrugInMapper {
    public void insertDrugIn(DrugIn drugIn);
    public List<DrugIn> selectAllDrugIn();
    public List<DrugIn> selectDrugInByKey(DrugInVo drugInVo);
    public DrugIn selectDrugInById(String inId);

}
