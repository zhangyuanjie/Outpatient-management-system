package com.zyj.hos.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zyj.hos.entity.Admin;
import com.zyj.hos.entity.Drug;
import com.zyj.hos.entity.DrugOut;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zyj
 * @date 2020/4/1 19:34
 */
public class DrugOutVo extends DrugOut {
    private String drugName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public DrugOutVo(String outId, Integer drugId, Integer outSum, Date outTime,  Drug drug, String drugName, Date startTime, Date endTime) {
        super(outId, drugId, outSum, outTime, drug);
        this.drugName = drugName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
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
