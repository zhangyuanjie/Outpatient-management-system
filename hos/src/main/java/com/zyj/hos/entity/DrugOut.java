package com.zyj.hos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zyj
 * @date 2020/4/1 16:20
 */
public class DrugOut {
    private String outId;
    private Integer drugId;
    private Integer outSum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date outTime;

    private Drug drug;

    public DrugOut() {
    }

    public DrugOut(String outId, Integer drugId, Integer outSum, Date outTime) {
        this.outId = outId;
        this.drugId = drugId;
        this.outSum = outSum;
        this.outTime = outTime;
    }

    public DrugOut(String outId, Integer drugId, Integer outSum, Date outTime, Drug drug) {
        this.outId = outId;
        this.drugId = drugId;
        this.outSum = outSum;
        this.outTime = outTime;
        this.drug = drug;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getOutSum() {
        return outSum;
    }

    public void setOutSum(Integer outSum) {
        this.outSum = outSum;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

}
