package com.zyj.hos.entity;

public class Patient {
    private Integer patientId;
    private String medicalCard;
    private String patientName;
    private String patientSex;
    private Integer patientAge;
    private String patientType;
    private String patientPhone;
    private String patientAddress;
    private String anamnesis;

    public Patient() {
    }

    public Patient(Integer patientId, String medicalCard, String patientName, String patientSex, Integer patientAge, String patientType, String patientPhone, String patientAddress, String anamnesis) {
        this.patientId = patientId;
        this.medicalCard = medicalCard;
        this.patientName = patientName;
        this.patientSex = patientSex;
        this.patientAge = patientAge;
        this.patientType = patientType;
        this.patientPhone = patientPhone;
        this.patientAddress = patientAddress;
        this.anamnesis = anamnesis;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(String medicalCard) {
        this.medicalCard = medicalCard;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }
}
