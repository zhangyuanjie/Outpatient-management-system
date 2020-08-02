package com.zyj.hos.service;

import com.zyj.hos.dao.RegistrationMapper;
import com.zyj.hos.entity.Registration;
import com.zyj.hos.vo.RegistrationVo;

import java.util.List;

public interface RegistrationService extends RegistrationMapper {
    public void insertRegistration(Registration registration);
    public List<Registration> selectNowReg(Integer userId);
    public List<Registration> selectOldReg(Integer userId);
    public Registration selectRegMore(String registrationId);
    public void deleteRegById(String registrationId);
    public void updateRegById(Registration registration);
    public List<Registration> selectRegByDocId(Integer doctorId);
    public void acceptRegById(String registrationId);
    public List<Registration> selectPatByDocId(Integer doctorId);
    public Registration selectPatByRegId(String registrationId);
    public Registration selectRegByRegId(String registrationId);
    public List<Registration> selectRegByKey(RegistrationVo registrationVo);
    public List<Registration> selectRegPatByKey(RegistrationVo registrationVo);
    public void updateStatusById(String registrationId);
    public List<Registration> selectAllReg();
    public List<Registration> selectRegMoreByKey(RegistrationVo registrationVo);
    public void timeOutReg();
    public Integer selectTodayReg(Integer doctorId);
}
