package com.zyj.hos.service;

import com.zyj.hos.dao.DepartmentMapper;
import com.zyj.hos.entity.Department;

import java.util.List;

public interface DepartmentService extends DepartmentMapper {
    public List<Department> selectAllDep();
    public Department selectDepById(Integer departmentId);
    public List<Department> selectDepByKey(Department department);
    public String selectDepByName(String departmentName);
    public void insertDep(Department department);
    public List<String> selectDepName();
}
