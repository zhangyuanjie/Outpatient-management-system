package com.zyj.hos.service.impl;

import com.zyj.hos.dao.DepartmentMapper;
import com.zyj.hos.entity.Department;
import com.zyj.hos.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAllDep() {
        return departmentMapper.selectAllDep();
    }

    @Override
    public Department selectDepById(Integer departmentId) {
        return departmentMapper.selectDepById(departmentId);
    }

    @Override
    public List<Department> selectDepByKey(Department department) {
        return departmentMapper.selectDepByKey(department);
    }

    @Override
    public String selectDepByName(String departmentName) {
        return departmentMapper.selectDepByName(departmentName);
    }

    @Override
    public void insertDep(Department department) {
        departmentMapper.insertDep(department);
    }

    @Override
    public List<String> selectDepName() {
        return departmentMapper.selectDepName();
    }
}
