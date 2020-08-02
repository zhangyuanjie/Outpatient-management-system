package com.zyj.hos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zyj
 * @date 2020/4/2 16:35
 */
public class Bill {
    private String billId;
    private Integer userId;
    private Integer billType;
    private String joinId;
    private String billDetails;
    private Float billPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date billTime;

    private User user;

    public Bill() {
    }

    public Bill(String billId, Integer userId, Integer billType, String joinId, String billDetails, Float billPrice, Date billTime) {
        this.billId = billId;
        this.userId = userId;
        this.billType = billType;
        this.joinId = joinId;
        this.billDetails = billDetails;
        this.billPrice = billPrice;
        this.billTime = billTime;
    }

    public Bill(String billId, Integer userId, Integer billType, String joinId, String billDetails, Float billPrice, Date billTime, User user) {
        this.billId = billId;
        this.userId = userId;
        this.billType = billType;
        this.joinId = joinId;
        this.billDetails = billDetails;
        this.billPrice = billPrice;
        this.billTime = billTime;
        this.user = user;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public String getJoinId() {
        return joinId;
    }

    public void setJoinId(String joinId) {
        this.joinId = joinId;
    }

    public String getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(String billDetails) {
        this.billDetails = billDetails;
    }

    public Float getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(Float billPrice) {
        this.billPrice = billPrice;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
