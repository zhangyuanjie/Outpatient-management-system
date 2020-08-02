package com.zyj.hos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyj.hos.entity.Diagnostic;
import com.zyj.hos.service.DiagnosticService;
import com.zyj.hos.service.MedicalRecordService;
import com.zyj.hos.vo.DiagnosticVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DiagnosticController {
    @Resource
    private DiagnosticService diagnosticService;

    @Resource
    private MedicalRecordService medicalRecordService;

    @RequestMapping("/insertDiaByRecId")
    @ResponseBody
    public String insertDiaByRecId(Diagnostic diagnostic){
        try{
            diagnosticService.insertDiaByRecId(diagnostic);
            return "insert dia success";
        }catch (Exception e){
            e.printStackTrace();
            return "insert dia false";
        }
    }

    @RequestMapping("/selectDiaByRecId")
    @ResponseBody
    public List<Diagnostic> selectDiaByRecId(@RequestParam String recordId){
        return diagnosticService.selectDiaByRecId(recordId);
    }

    @RequestMapping("/selectDiaByDocId")
    @ResponseBody
    public PageInfo<Diagnostic> selectDiaByDocId(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @RequestParam Integer doctorId){
        PageHelper.startPage(pageNum,5);
        List<Diagnostic> diagnostics = diagnosticService.selectDiaByDocId(doctorId);
        PageInfo<Diagnostic> pageInfo = new PageInfo<>(diagnostics);
        return pageInfo;
    }

    @RequestMapping("/selectResByDiaId")
    @ResponseBody
    public String selectResByDiaId(@RequestParam Integer diagnosticId){
        return diagnosticService.selectResByDiaId(diagnosticId);
    }

    @RequestMapping("/selectDiaByKey")
    @ResponseBody
    public PageInfo<Diagnostic> selectDiaByKey(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, DiagnosticVo diagnosticVo){
        PageHelper.startPage(pageNum,5);
        List<Diagnostic> diagnostics = diagnosticService.selectDiaByKey(diagnosticVo);
        PageInfo<Diagnostic> pageInfo = new PageInfo<>(diagnostics);
        return pageInfo;
    }
}
