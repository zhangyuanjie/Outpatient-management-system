package com.zyj.hos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class MedicalRecord {
    private String recordId;
    private String medicalCard;
    private Integer recordStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private List<Diagnostic> diagnostics;
    private Patient patient;

    public MedicalRecord() {
    }

    public MedicalRecord(String recordId, String medicalCard, Integer recordStatus, Date createTime) {
        this.recordId = recordId;
        this.medicalCard = medicalCard;
        this.recordStatus = recordStatus;
        this.createTime = createTime;
    }

    public MedicalRecord(String recordId, String medicalCard,  Integer recordStatus, Date createTime, List<Diagnostic> diagnostics, Patient patient) {
        this.recordId = recordId;
        this.medicalCard = medicalCard;
        this.recordStatus = recordStatus;
        this.createTime = createTime;
        this.diagnostics = diagnostics;
        this.patient = patient;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(String medicalCard) {
        this.medicalCard = medicalCard;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Diagnostic> getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(List<Diagnostic> diagnostics) {
        this.diagnostics = diagnostics;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
