package com.zyj.hos.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zyj.hos.entity.Patient;
import com.zyj.hos.entity.Prescription;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zyj
 * @date 2020/3/29 14:00
 */
public class PrescriptionVo extends Prescription {
    private String patientName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public PrescriptionVo(String prescriptionId, String medicalCard, String recordId, Integer departmentId, String diagnostic, Date prescriptionTime, String doctorId, Float totalPrice, Integer prescriptionStatus, Patient patient, String patientName, Date startTime, Date endTime) {
        super(prescriptionId, medicalCard, recordId, departmentId, diagnostic, prescriptionTime, doctorId, totalPrice, prescriptionStatus, patient);
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
