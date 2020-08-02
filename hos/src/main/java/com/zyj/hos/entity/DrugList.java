package com.zyj.hos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DrugList {
    private Integer listId;
    private Integer drugId;
    private Integer drugNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private String prescriptionId;

    private Drug drug;

    public DrugList() {
    }

    public DrugList(Integer listId, Integer drugId, Integer drugNum, Date createTime, String prescriptionId) {
        this.listId = listId;
        this.drugId = drugId;
        this.drugNum = drugNum;
        this.createTime = createTime;
        this.prescriptionId = prescriptionId;
    }

    public DrugList(Integer listId, Integer drugId, Integer drugNum, Date createTime, String prescriptionId, Drug drug) {
        this.listId = listId;
        this.drugId = drugId;
        this.drugNum = drugNum;
        this.createTime = createTime;
        this.prescriptionId = prescriptionId;
        this.drug = drug;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(Integer drugNum) {
        this.drugNum = drugNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
