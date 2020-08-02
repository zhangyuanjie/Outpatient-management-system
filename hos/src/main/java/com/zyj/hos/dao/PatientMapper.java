package com.zyj.hos.dao;

import com.zyj.hos.entity.Patient;

public interface PatientMapper {
    public void insertPatient(Patient patient);
    public void updatePatById(Patient patient);
    public Patient selectCard(String medicalCard);
    public void updateTypeByCard(String medicalCard);
    public Patient selectPatByRecId(String recordId);
}
