package com.zyj.hos.entity;

public class Doctor {
    private Integer doctorId;
    private String doctorAccount;
    private String doctorName;
    private String doctorPwd;
    private Integer doctorAge;
    private String doctorSex;
    private String doctorType;
    private String doctorEmail;
    private String doctorPhone;
    private String doctorAddress;
    private String doctorStatus;
    private Integer departmentId;
    private String workTime;
    private String doctorDetails;
    private Float attendancePrice;// 出诊费用

    private Department department;

    public Doctor() {
    }

    public Doctor(Integer doctorId, String doctorAccount, String doctorName, String doctorPwd, Integer doctorAge, String doctorSex, String doctorType, String doctorEmail, String doctorPhone, String doctorAddress, String doctorStatus, Integer departmentId, String workTime, String doctorDetails, Float attendancePrice, Department department) {
        this.doctorId = doctorId;
        this.doctorAccount = doctorAccount;
        this.doctorName = doctorName;
        this.doctorPwd = doctorPwd;
        this.doctorAge = doctorAge;
        this.doctorSex = doctorSex;
        this.doctorType = doctorType;
        this.doctorEmail = doctorEmail;
        this.doctorPhone = doctorPhone;
        this.doctorAddress = doctorAddress;
        this.doctorStatus = doctorStatus;
        this.departmentId = departmentId;
        this.workTime = workTime;
        this.doctorDetails = doctorDetails;
        this.attendancePrice = attendancePrice;
        this.department = department;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorAccount() {
        return doctorAccount;
    }

    public void setDoctorAccount(String doctorAccount) {
        this.doctorAccount = doctorAccount;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPwd() {
        return doctorPwd;
    }

    public void setDoctorPwd(String doctorPwd) {
        this.doctorPwd = doctorPwd;
    }

    public Integer getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(Integer doctorAge) {
        this.doctorAge = doctorAge;
    }

    public String getDoctorSex() {
        return doctorSex;
    }

    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getDoctorStatus() {
        return doctorStatus;
    }

    public void setDoctorStatus(String doctorStatus) {
        this.doctorStatus = doctorStatus;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(String doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    public Float getAttendancePrice() {
        return attendancePrice;
    }

    public void setAttendancePrice(Float attendancePrice) {
        this.attendancePrice = attendancePrice;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
