package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.entity.Department;
import com.zyj.hos.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/selectDep")
    @ResponseBody
    public List<Department> selectDep(){
        return departmentService.selectAllDep();
    }

    @RequestMapping("/selectDepByPage")
    @ResponseBody
    public PageInfo<Department> selectDepByPage(@RequestParam(defaultValue = "1",value="pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Department> departments = departmentService.selectAllDep();
        PageInfo<Department> pageInfo = new PageInfo<Department>(departments);
        return pageInfo;
    }


    @RequestMapping("/selectDepByKey")
    @ResponseBody
    public PageInfo<Department> selectDepByKey(@RequestParam(defaultValue = "1",value="pageNum") Integer pageNum, Department department){
        PageHelper.startPage(pageNum,5);
        List<Department> departments = departmentService.selectDepByKey(department);
        PageInfo<Department> pageInfo = new PageInfo<Department>(departments);
        return pageInfo;
    }

    @RequestMapping("/selectDepById")
    @ResponseBody
    public Department selectDepById(@RequestParam Integer departmentId){
        return departmentService.selectDepById(departmentId);
    }

    @RequestMapping("/insertDepartment")
    @ResponseBody
    public String insertDep(Department department){
        try{
            String departmentName = department.getDepartmentName();
            if(departmentService.selectDepByName(departmentName)!=null){
                return "dep is exist";
            }else {
                departmentService.insertDep(department);
                return "insert dep success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "insert dep fail";
        }
    }

    @RequestMapping("/selectDepName")
    @ResponseBody
    public List<String> selectDepName(){
        return departmentService.selectDepName();
    }

    @RequestMapping("/selectAllDep")
    @ResponseBody
    public List<Department> selectAllDep(){
        return departmentService.selectAllDep();
    }
}
