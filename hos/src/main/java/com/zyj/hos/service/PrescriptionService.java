package com.zyj.hos.service;

import com.zyj.hos.dao.PrescriptionMapper;
import com.zyj.hos.entity.Prescription;
import com.zyj.hos.vo.PrescriptionVo;

import java.util.List;

public interface PrescriptionService extends PrescriptionMapper {
    public void insertPre(Prescription prescription);
    public String selectPreById(String prescriptionId);
    public List<Prescription> selectPrePatByDocId(Integer doctorId);
    public List<Prescription> selectPrePatByKey(PrescriptionVo prescriptionVo);
    public Prescription selectPrePatByPreId(String prescriptionId);
    public List<Prescription> selectPrePatByUserId(Integer userId);
    public List<Prescription> selectAllPre();
    public void updatePrePaid(String prescriptionId);
    public List<String> selectTimeOutPre();
    public void updateTimeOutPre();
}
