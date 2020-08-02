package com.zyj.hos.service.impl;

import com.zyj.hos.dao.DoctorMapper;
import com.zyj.hos.entity.Doctor;
import com.zyj.hos.service.DoctorService;
import com.zyj.hos.vo.DoctorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public Doctor selectDoctorByAccount(String doctorAccount) {
        return doctorMapper.selectDoctorByAccount(doctorAccount);
    }

    @Override
    public Doctor selectDoctor(Doctor doctor) {
        return doctorMapper.selectDoctor(doctor);
    }

    @Override
    public List<Doctor> selectDoctorByDepId(Integer departmentId) {
        return doctorMapper.selectDoctorByDepId(departmentId);
    }

    @Override
    public Doctor selectDoctorById(Integer doctorId) {
        return doctorMapper.selectDoctorById(doctorId);
    }

    @Override
    public Doctor selectDoctorDepById(Integer doctorId) {
        return doctorMapper.selectDoctorDepById(doctorId);
    }

    @Override
    public List<Doctor> selectDoctorByKey(DoctorVo doctorVo) {
        return doctorMapper.selectDoctorByKey(doctorVo);
    }

    @Override
    public List<Doctor> selectAllDoctor() {
        return doctorMapper.selectAllDoctor();
    }

    @Override
    public void updateDoctorById(Doctor doctor) {
        doctorMapper.updateDoctorById(doctor);
    }

    @Override
    public String selectPwdById(Integer doctorId) {
        return doctorMapper.selectPwdById(doctorId);
    }

    @Override
    public void updatePwdById(Doctor doctor) {
        doctorMapper.updatePwdById(doctor);
    }

    @Override
    public String selectDocByAccount(String doctorAccount) {
        return doctorMapper.selectDocByAccount(doctorAccount);
    }

    @Override
    public void insertDoctor(Doctor doctor) {
        doctorMapper.insertDoctor(doctor);
    }

    @Override
    public void updateDocById(Doctor doctor) {
        doctorMapper.updateDocById(doctor);
    }

    @Override
    public void updatePwdByAccount(Doctor doctor) {
        doctorMapper.updatePwdByAccount(doctor);
    }
}
