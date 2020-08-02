package com.zyj.hos.service;

import com.zyj.hos.dao.PatientMapper;
import com.zyj.hos.entity.Patient;

public interface PatientService extends PatientMapper {
    public void insertPatient(Patient patient);
    public void updatePatById(Patient patient);
    public Patient selectCard(String medicalCard);
    public void updateTypeByCard(String medicalCard);
    public Patient selectPatByRecId(String recordId);
}
