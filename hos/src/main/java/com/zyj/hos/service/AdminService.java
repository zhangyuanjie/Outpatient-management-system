package com.zyj.hos.service;

import com.zyj.hos.dao.AdminMapper;
import com.zyj.hos.entity.Admin;

import java.util.List;

public interface AdminService extends AdminMapper {
    public Admin selectAdminByAccount(String adminAccount);
    public Admin selectAdminById(Integer adminId);
    public Admin selectAdmin(Admin admin);
    public void updateAdminById(Admin admin);
    public String selectPwdById(Integer adminId);
    public void updatePwdById(Admin admin);
    public void updatePwdByAccount(Admin admin);
    public List<Admin> selectAllAdmin();
    public List<Admin> selectAdminByKey(Admin admin);
    public void insertAdmin(Admin admin);
}
