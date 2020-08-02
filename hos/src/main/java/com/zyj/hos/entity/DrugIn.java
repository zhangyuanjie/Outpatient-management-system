package com.zyj.hos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zyj
 * @date 2020/4/1 16:20
 */
public class DrugIn {
    private String inId;
    private Integer drugId;
    private Integer inSum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date inTime;
    private Integer adminId;

    private Drug drug;
    private Admin admin;

    public DrugIn() {
    }

    public DrugIn(String inId, Integer drugId, Integer inSum, Date inTime, Integer adminId) {
        this.inId = inId;
        this.drugId = drugId;
        this.inSum = inSum;
        this.inTime = inTime;
        this.adminId = adminId;
    }

    public DrugIn(String inId, Integer drugId, Integer inSum, Date inTime, Integer adminId, Drug drug, Admin admin) {
        this.inId = inId;
        this.drugId = drugId;
        this.inSum = inSum;
        this.inTime = inTime;
        this.adminId = adminId;
        this.drug = drug;
        this.admin = admin;
    }

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getInSum() {
        return inSum;
    }

    public void setInSum(Integer inSum) {
        this.inSum = inSum;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
