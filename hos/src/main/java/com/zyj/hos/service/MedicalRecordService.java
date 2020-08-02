package com.zyj.hos.service;

import com.zyj.hos.dao.MedicalRecordMapper;
import com.zyj.hos.entity.MedicalRecord;
import com.zyj.hos.vo.MedicalRecordVo;

import java.util.List;

public interface MedicalRecordService extends MedicalRecordMapper {
    public MedicalRecord selectRecAndDiaById(String recordId);
    public MedicalRecord selectRecByCard(String medicalCard);
    public MedicalRecord selectRecById(String recordId);
    public void insertRec(MedicalRecord medicalRecord);
//    public List<MedicalRecord> selectRecAndDiaByKey(MedicalRecordVo medicalRecordVo);
    public List<MedicalRecord> selectRecByUserId(Integer userId);
    public List<MedicalRecord> selectAllRec();
    public List<MedicalRecord> selectRecByKey(MedicalRecordVo medicalRecordVo);
}
