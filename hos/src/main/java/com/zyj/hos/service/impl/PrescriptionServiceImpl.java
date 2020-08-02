package com.zyj.hos.service.impl;

import com.zyj.hos.dao.PrescriptionMapper;
import com.zyj.hos.entity.Prescription;
import com.zyj.hos.service.PrescriptionService;
import com.zyj.hos.vo.PrescriptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    private PrescriptionMapper prescriptionMapper;

    @Override
    public void insertPre(Prescription prescription) {
        prescriptionMapper.insertPre(prescription);
    }

    @Override
    public String selectPreById(String prescriptionId) {
        return prescriptionMapper.selectPreById(prescriptionId);
    }

    @Override
    public List<Prescription> selectPrePatByDocId(Integer doctorId) {
        return prescriptionMapper.selectPrePatByDocId(doctorId);
    }

    @Override
    public List<Prescription> selectPrePatByKey(PrescriptionVo prescriptionVo) {
        return prescriptionMapper.selectPrePatByKey(prescriptionVo);
    }

    @Override
    public Prescription selectPrePatByPreId(String prescriptionId) {
        return prescriptionMapper.selectPrePatByPreId(prescriptionId);
    }

    @Override
    public List<Prescription> selectPrePatByUserId(Integer userId) {
        return prescriptionMapper.selectPrePatByUserId(userId);
    }

    @Override
    public List<Prescription> selectAllPre() {
        return prescriptionMapper.selectAllPre();
    }

    @Override
    public void updatePrePaid(String prescriptionId) {
        prescriptionMapper.updatePrePaid(prescriptionId);
    }

    @Override
    public List<String> selectTimeOutPre() {
        return prescriptionMapper.selectTimeOutPre();
    }

    @Override
    public void updateTimeOutPre() {
        prescriptionMapper.updateTimeOutPre();
    }
}
