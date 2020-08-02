package com.zyj.hos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Diagnostic {
    private Integer diagnosticId;
    private Integer departmentId;
    private Integer doctorId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date diagnosticTime;
    private String diagnosticResult;
    private String recordId;

    private Department department;
    private Doctor doctor;

    private Patient patient;

    public Diagnostic() {
    }

    public Diagnostic(Integer diagnosticId, Integer departmentId, Integer doctorId, Date diagnosticTime, String diagnosticResult, String recordId) {
        this.diagnosticId = diagnosticId;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.diagnosticTime = diagnosticTime;
        this.diagnosticResult = diagnosticResult;
        this.recordId = recordId;
    }

    public Diagnostic(Integer diagnosticId, Integer departmentId, Integer doctorId, Date diagnosticTime, String diagnosticResult, String recordId, Department department, Doctor doctor) {
        this.diagnosticId = diagnosticId;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.diagnosticTime = diagnosticTime;
        this.diagnosticResult = diagnosticResult;
        this.recordId = recordId;
        this.department = department;
        this.doctor = doctor;
    }

    public Diagnostic(Integer diagnosticId, Integer departmentId, Integer doctorId, Date diagnosticTime, String diagnosticResult, String recordId, Department department, Doctor doctor, Patient patient) {
        this.diagnosticId = diagnosticId;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.diagnosticTime = diagnosticTime;
        this.diagnosticResult = diagnosticResult;
        this.recordId = recordId;
        this.department = department;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Integer getDiagnosticId() {
        return diagnosticId;
    }

    public void setDiagnosticId(Integer diagnosticId) {
        this.diagnosticId = diagnosticId;
    }

    public Date getDiagnosticTime() {
        return diagnosticTime;
    }

    public void setDiagnosticTime(Date diagnosticTime) {
        this.diagnosticTime = diagnosticTime;
    }

    public String getDiagnosticResult() {
        return diagnosticResult;
    }

    public void setDiagnosticResult(String diagnosticResult) {
        this.diagnosticResult = diagnosticResult;
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

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
