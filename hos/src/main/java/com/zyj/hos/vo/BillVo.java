package com.zyj.hos.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zyj.hos.entity.Bill;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zyj
 * @date 2020/4/3 0:37
 */
public class BillVo extends Bill {
    private String userName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public BillVo(String userName, String billId, Integer userId, Integer billType, String joinId, String billDetails, Float billPrice, Date billTime, Date startTime, Date endTime) {
        super(billId, userId, billType, joinId, billDetails, billPrice, billTime);
        this.userName = userName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
