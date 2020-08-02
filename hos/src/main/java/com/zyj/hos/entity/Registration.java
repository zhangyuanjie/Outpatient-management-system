package com.zyj.hos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Registration {
    private String registrationId;
    private Integer departmentId;
    private String registrationType;
    private String medicalCard;
    private String patientName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registrationTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date appointmentTime;
    private Float registrationPrice;
    private Integer registrationStatus;
    private Integer doctorId;
    private Integer userId;

    private Patient patient;
    private Department department;
    private Doctor doctor;
    private User user;

    public Registration() {
    }

    public Registration(String registrationId, Integer departmentId, String registrationType, String medicalCard, String patientName, Date registrationTime, Date appointmentTime, Float registrationPrice, Integer registrationStatus, Integer doctorId, Integer userId) {
        this.registrationId = registrationId;
        this.departmentId = departmentId;
        this.registrationType = registrationType;
        this.medicalCard = medicalCard;
        this.patientName = patientName;
        this.registrationTime = registrationTime;
        this.appointmentTime = appointmentTime;
        this.registrationPrice = registrationPrice;
        this.registrationStatus = registrationStatus;
        this.doctorId = doctorId;
        this.userId = userId;
    }

    public Registration(String registrationId, Integer departmentId, String registrationType, String medicalCard, String patientName, Date registrationTime, Date appointmentTime, Float registrationPrice, Integer registrationStatus, Integer doctorId, Integer userId, Patient patient, Department department, Doctor doctor, User user) {
        this.registrationId = registrationId;
        this.departmentId = departmentId;
        this.registrationType = registrationType;
        this.medicalCard = medicalCard;
        this.patientName = patientName;
        this.registrationTime = registrationTime;
        this.appointmentTime = appointmentTime;
        this.registrationPrice = registrationPrice;
        this.registrationStatus = registrationStatus;
        this.doctorId = doctorId;
        this.userId = userId;
        this.patient = patient;
        this.department = department;
        this.doctor = doctor;
        this.user = user;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
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

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Float getRegistrationPrice() {
        return registrationPrice;
    }

    public void setRegistrationPrice(Float registrationPrice) {
        this.registrationPrice = registrationPrice;
    }

    public Integer getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(Integer registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
