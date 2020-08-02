package com.zyj.hos.vo;

import com.zyj.hos.entity.Department;
import com.zyj.hos.entity.Doctor;

/**
 * @author zyj
 * @date 2020/4/9 10:52
 */
public class DoctorVo extends Doctor {
    private String departmentName;

    public DoctorVo(Integer doctorId, String doctorAccount, String doctorName, String doctorPwd, Integer doctorAge, String doctorSex, String doctorType, String doctorEmail, String doctorPhone, String doctorAddress, String doctorStatus, Integer departmentId, String workTime, String doctorDetails, Float attendancePrice, Department department, String departmentName) {
        super(doctorId, doctorAccount, doctorName, doctorPwd, doctorAge, doctorSex, doctorType, doctorEmail, doctorPhone, doctorAddress, doctorStatus, departmentId, workTime, doctorDetails, attendancePrice, department);
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
