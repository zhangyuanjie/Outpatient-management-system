package com.zyj.hos.entity;

public class Department {
    private Integer departmentId;
    private String departmentName;
    private String departmentDetails;

    public Department() {
    }

    public Department(Integer departmentId, String departmentName, String departmentDetails) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentDetails = departmentDetails;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDetails() {
        return departmentDetails;
    }

    public void setDepartmentDetails(String departmentDetails) {
        this.departmentDetails = departmentDetails;
    }
}
