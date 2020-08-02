package com.zyj.hos.dao;

import com.zyj.hos.entity.Doctor;
import com.zyj.hos.vo.DoctorVo;

import java.util.List;

public interface DoctorMapper {
    public Doctor selectDoctorByAccount(String doctorAccount);
    public Doctor selectDoctor(Doctor doctor);
    public List<Doctor> selectDoctorByDepId(Integer departmentId);
    public Doctor selectDoctorById(Integer doctorId);
    public Doctor selectDoctorDepById(Integer doctorId);
    public List<Doctor> selectDoctorByKey(DoctorVo doctorVo);
    public List<Doctor> selectAllDoctor();
    public void updateDoctorById(Doctor doctor);
    public String selectPwdById(Integer doctorId);
    public void updatePwdById(Doctor doctor);
    public String selectDocByAccount(String doctorAccount);
    public void insertDoctor(Doctor doctor);
    public void updateDocById(Doctor doctor);
    public void updatePwdByAccount(Doctor doctor);
}
