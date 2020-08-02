package com.zyj.hos.service;

import com.zyj.hos.dao.DrugOutMapper;
import com.zyj.hos.entity.DrugOut;
import com.zyj.hos.vo.DrugOutVo;

import java.util.List;

/**
 * @author zyj
 * @date 2020/4/1 17:07
 */
public interface DrugOutService extends DrugOutMapper {
    public void insertDrugOut(DrugOut drugOut);
    public List<DrugOut> selectAllDrugOut();
    public List<DrugOut> selectDrugOutByKey(DrugOutVo drugOutVo);
}
