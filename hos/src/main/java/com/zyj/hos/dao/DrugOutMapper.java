package com.zyj.hos.dao;

import com.zyj.hos.entity.DrugOut;
import com.zyj.hos.vo.DrugOutVo;

import java.util.List;

/**
 * @author zyj
 * @date 2020/4/1 17:06
 */
public interface DrugOutMapper {
    public void insertDrugOut(DrugOut drugOut);
    public List<DrugOut> selectAllDrugOut();
    public List<DrugOut> selectDrugOutByKey(DrugOutVo drugOutVo);
}
