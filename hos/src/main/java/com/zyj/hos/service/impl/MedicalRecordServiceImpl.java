package com.zyj.hos.service.impl;

import com.zyj.hos.dao.MedicalRecordMapper;
import com.zyj.hos.entity.MedicalRecord;
import com.zyj.hos.service.MedicalRecordService;
import com.zyj.hos.vo.MedicalRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    private MedicalRecordMapper medicalRecordMapper;

    @Override
    public MedicalRecord selectRecAndDiaById(String recordId) {
        return medicalRecordMapper.selectRecAndDiaById(recordId);
    }

    @Override
    public MedicalRecord selectRecByCard(String medicalCard) {
        return medicalRecordMapper.selectRecByCard(medicalCard);
    }

    @Override
    public MedicalRecord selectRecById(String recordId) {
        return medicalRecordMapper.selectRecById(recordId);
    }

    @Override
    public void insertRec(MedicalRecord medicalRecord) {
        medicalRecordMapper.insertRec(medicalRecord);
    }

//    @Override
//    public List<MedicalRecord> selectRecAndDiaByKey(MedicalRecordVo medicalRecordVo) {
//        return medicalRecordMapper.selectRecAndDiaByKey(medicalRecordVo);
//    }


    @Override
    public List<MedicalRecord> selectRecByUserId(Integer userId) {
        return medicalRecordMapper.selectRecByUserId(userId);
    }

    @Override
    public List<MedicalRecord> selectAllRec() {
        return medicalRecordMapper.selectAllRec();
    }

    @Override
    public List<MedicalRecord> selectRecByKey(MedicalRecordVo medicalRecordVo) {
        return medicalRecordMapper.selectRecByKey(medicalRecordVo);
    }
}
