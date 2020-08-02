package com.zyj.hos.service.impl;

import com.zyj.hos.dao.AdminMapper;
import com.zyj.hos.entity.Admin;
import com.zyj.hos.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin selectAdminByAccount(String adminAccount) {
        return adminMapper.selectAdminByAccount(adminAccount);
    }

    @Override
    public Admin selectAdminById(Integer adminId) {
        return adminMapper.selectAdminById(adminId);
    }

    @Override
    public Admin selectAdmin(Admin admin) {
        return adminMapper.selectAdmin(admin);
    }

    @Override
    public void updateAdminById(Admin admin) {
        adminMapper.updateAdminById(admin);
    }

    @Override
    public String selectPwdById(Integer adminId) {
        return adminMapper.selectPwdById(adminId);
    }

    @Override
    public void updatePwdById(Admin admin) {
        adminMapper.updatePwdById(admin);
    }

    @Override
    public void updatePwdByAccount(Admin admin) {
        adminMapper.updatePwdByAccount(admin);
    }

    @Override
    public List<Admin> selectAllAdmin() {
        return adminMapper.selectAllAdmin();
    }

    @Override
    public List<Admin> selectAdminByKey(Admin admin) {
        return adminMapper.selectAdminByKey(admin);
    }

    @Override
    public void insertAdmin(Admin admin) {
        adminMapper.insertAdmin(admin);
    }
}
