package com.zyj.hos.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zyj.hos.entity.Diagnostic;
import com.zyj.hos.entity.MedicalRecord;
import com.zyj.hos.entity.Patient;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author zyj
 * @date 2020/3/28 9:34
 */
public class MedicalRecordVo extends MedicalRecord {
    private String patientName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public MedicalRecordVo(String recordId, String medicalCard, Integer recordStatus, Date createTime, List<Diagnostic> diagnostics, Patient patient, String patientName, Date startTime, Date endTime) {
        super(recordId, medicalCard, recordStatus, createTime, diagnostics, patient);
        this.patientName = patientName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
