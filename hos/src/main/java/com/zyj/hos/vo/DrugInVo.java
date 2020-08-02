package com.zyj.hos.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zyj.hos.entity.Admin;
import com.zyj.hos.entity.Drug;
import com.zyj.hos.entity.DrugIn;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zyj
 * @date 2020/4/1 19:32
 */
public class DrugInVo extends DrugIn {
    private String drugName;
    private String adminName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public DrugInVo(String inId, Integer drugId, Integer inSum, Date inTime, Integer adminId, Drug drug, Admin admin, String drugName, String adminName, Date startTime, Date endTime) {
        super(inId, drugId, inSum, inTime, adminId, drug, admin);
        this.drugName = drugName;
        this.adminName = adminName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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
