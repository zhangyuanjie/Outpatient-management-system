package com.zyj.hos.service.impl;

import com.zyj.hos.dao.DiagnosticMapper;
import com.zyj.hos.entity.Diagnostic;
import com.zyj.hos.service.DiagnosticService;
import com.zyj.hos.vo.DiagnosticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticServiceImpl implements DiagnosticService {
    @Autowired
    private DiagnosticMapper diagnosticMapper;

    @Override
    public void insertDiaByRecId(Diagnostic diagnostic) {
        diagnosticMapper.insertDiaByRecId(diagnostic);
    }

    @Override
    public List<Diagnostic> selectDiaByRecId(String recordId) {
        return diagnosticMapper.selectDiaByRecId(recordId);
    }

    @Override
    public List<Diagnostic> selectDiaByDocId(Integer doctorId) {
        return diagnosticMapper.selectDiaByDocId(doctorId);
    }

    @Override
    public String selectResByDiaId(Integer diagnosticId) {
        return diagnosticMapper.selectResByDiaId(diagnosticId);
    }

    @Override
    public List<Diagnostic> selectDiaByKey(DiagnosticVo diagnosticVo) {
        return diagnosticMapper.selectDiaByKey(diagnosticVo);
    }
}
