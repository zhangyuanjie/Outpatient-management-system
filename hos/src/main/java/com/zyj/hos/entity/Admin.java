package com.zyj.hos.entity;

public class Admin {
    private Integer adminId;
    private String adminAccount;
    private String adminName;
    private String adminSex;
    private Integer adminAge;
    private String adminPwd;
    private String adminEmail;
    private String adminPhone;

    public Admin() {
    }

    public Admin(Integer adminId, String adminAccount, String adminName, String adminSex, Integer adminAge, String adminPwd, String adminEmail, String adminPhone) {
        this.adminId = adminId;
        this.adminAccount = adminAccount;
        this.adminName = adminName;
        this.adminSex = adminSex;
        this.adminAge = adminAge;
        this.adminPwd = adminPwd;
        this.adminEmail = adminEmail;
        this.adminPhone = adminPhone;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public Integer getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(Integer adminAge) {
        this.adminAge = adminAge;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }
}
