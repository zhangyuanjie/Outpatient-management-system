package com.zyj.hos.service.impl;

import com.zyj.hos.dao.PatientMapper;
import com.zyj.hos.entity.Patient;
import com.zyj.hos.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public void insertPatient(Patient patient) {
        patientMapper.insertPatient(patient);
    }

    @Override
    public void updatePatById(Patient patient) {
        patientMapper.updatePatById(patient);
    }

    @Override
    public Patient selectCard(String medicalCard) {
        return patientMapper.selectCard(medicalCard);
    }

    @Override
    public void updateTypeByCard(String medicalCard) {
        patientMapper.updateTypeByCard(medicalCard);
    }

    @Override
    public Patient selectPatByRecId(String recordId) {
        return patientMapper.selectPatByRecId(recordId);
    }
}
