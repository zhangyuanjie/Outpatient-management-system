package com.zyj.hos.dao;

import com.zyj.hos.entity.Department;

import java.util.List;

public interface DepartmentMapper {
    public List<Department> selectAllDep();
    public Department selectDepById(Integer departmentId);
    public List<Department> selectDepByKey(Department department);
    public String selectDepByName(String departmentName);
    public void insertDep(Department department);
    public List<String> selectDepName();
}
