package com.zyj.hos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Prescription {
    private String prescriptionId;
    private String medicalCard;
    private String recordId;
    private Integer departmentId;
    private String diagnostic;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date prescriptionTime;
    private String doctorId;
    private Float totalPrice;
    private Integer prescriptionStatus;
    private Patient patient;

    public Prescription() {
    }

    public Prescription(String prescriptionId, String medicalCard, String recordId, Integer departmentId, String diagnostic, Date prescriptionTime, String doctorId, Float totalPrice, Integer prescriptionStatus) {
        this.prescriptionId = prescriptionId;
        this.medicalCard = medicalCard;
        this.recordId = recordId;
        this.departmentId = departmentId;
        this.diagnostic = diagnostic;
        this.prescriptionTime = prescriptionTime;
        this.doctorId = doctorId;
        this.totalPrice = totalPrice;
        this.prescriptionStatus = prescriptionStatus;
    }

    public Prescription(String prescriptionId, String medicalCard, String recordId, Integer departmentId, String diagnostic, Date prescriptionTime, String doctorId, Float totalPrice, Integer prescriptionStatus, Patient patient) {
        this.prescriptionId = prescriptionId;
        this.medicalCard = medicalCard;
        this.recordId = recordId;
        this.departmentId = departmentId;
        this.diagnostic = diagnostic;
        this.prescriptionTime = prescriptionTime;
        this.doctorId = doctorId;
        this.totalPrice = totalPrice;
        this.prescriptionStatus = prescriptionStatus;
        this.patient = patient;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(String medicalCard) {
        this.medicalCard = medicalCard;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Date getPrescriptionTime() {
        return prescriptionTime;
    }

    public void setPrescriptionTime(Date prescriptionTime) {
        this.prescriptionTime = prescriptionTime;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPrescriptionStatus() {
        return prescriptionStatus;
    }

    public void setPrescriptionStatus(Integer prescriptionStatus) {
        this.prescriptionStatus = prescriptionStatus;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
