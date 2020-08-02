package com.zyj.hos.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zyj.hos.entity.Department;
import com.zyj.hos.entity.Diagnostic;
import com.zyj.hos.entity.Doctor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zyj
 * @date 2020/3/28 10:40
 */
public class DiagnosticVo extends Diagnostic {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public DiagnosticVo(Integer diagnosticId, Integer departmentId, Integer doctorId, Date diagnosticTime, String diagnosticResult, String recordId, Department department, Doctor doctor, Date startTime, Date endTime) {
        super(diagnosticId, departmentId, doctorId, diagnosticTime, diagnosticResult, recordId, department, doctor);
        this.startTime = startTime;
        this.endTime = endTime;
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
