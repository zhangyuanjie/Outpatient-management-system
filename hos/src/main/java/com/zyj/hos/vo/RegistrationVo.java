package com.zyj.hos.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zyj.hos.entity.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RegistrationVo extends Registration {
    private String departmentName;
    private String doctorName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public RegistrationVo(String registrationId, Integer departmentId, String registrationType, String medicalCard, String patientName, Date registrationTime, Date appointmentTime, Float registrationPrice, Integer registrationStatus, Integer doctorId, Integer userId, Patient patient, Department department, Doctor doctor, User user, String departmentName, String doctorName, Date startTime, Date endTime) {
        super(registrationId, departmentId, registrationType, medicalCard, patientName, registrationTime, appointmentTime, registrationPrice, registrationStatus, doctorId, userId, patient, department, doctor, user);
        this.departmentName = departmentName;
        this.doctorName = doctorName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
