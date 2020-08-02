package com.zyj.hos.dao;

import com.zyj.hos.entity.Diagnostic;
import com.zyj.hos.vo.DiagnosticVo;

import java.util.List;

public interface DiagnosticMapper {
    public void insertDiaByRecId(Diagnostic diagnostic);
    public List<Diagnostic> selectDiaByRecId(String recordId);
    public List<Diagnostic> selectDiaByDocId(Integer doctorId);
    public String selectResByDiaId(Integer diagnosticId);
    public List<Diagnostic> selectDiaByKey(DiagnosticVo diagnosticVo);
}
