package com.zyj.hos.service.impl;

import com.zyj.hos.dao.RegistrationMapper;
import com.zyj.hos.entity.Registration;
import com.zyj.hos.service.RegistrationService;
import com.zyj.hos.vo.RegistrationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public void insertRegistration(Registration registration) {
        registrationMapper.insertRegistration(registration);
    }

    @Override
    public List<Registration> selectNowReg(Integer userId) {
        return registrationMapper.selectNowReg(userId);
    }

    @Override
    public List<Registration> selectOldReg(Integer userId) {
        return registrationMapper.selectOldReg(userId);
    }

    @Override
    public Registration selectRegMore(String registrationId) {
        return registrationMapper.selectRegMore(registrationId);
    }

    @Override
    public void deleteRegById(String registrationId) {
        registrationMapper.deleteRegById(registrationId);
    }

    @Override
    public void updateRegById(Registration registration) {
        registrationMapper.updateRegById(registration);
    }

    @Override
    public List<Registration> selectRegByDocId(Integer doctorId) {
        return registrationMapper.selectRegByDocId(doctorId);
    }

    @Override
    public void acceptRegById(String registrationId) {
        registrationMapper.acceptRegById(registrationId);
    }

    @Override
    public List<Registration> selectPatByDocId(Integer doctorId) {
        return registrationMapper.selectPatByDocId(doctorId);
    }

    /*
     * @Author zhangyuanjie
     * @Description //TODO 
     * @Date 13:30 2020/3/27
     * @Param [registrationId]
     * @return com.zyj.hos.entity.Registration
    **/
    @Override
    public Registration selectPatByRegId(String registrationId) {
        return registrationMapper.selectPatByRegId(registrationId);
    }

    /*
     * @Author zhangyuanjie
     * @Description //TODO 
     * @Date 13:31 2020/3/27
     * @Param [registrationId]
     * @return com.zyj.hos.entity.Registration
    **/
    @Override
    public Registration selectRegByRegId(String registrationId) {
        return registrationMapper.selectRegByRegId(registrationId);
    }

    /*
     * @Author zhangyuanjie
     * @Description //TODO
     * @Date 13:32 2020/3/27
     * @Param [registrationVo]
     * @return com.zyj.hos.entity.Registration
    **/
    @Override
    public List<Registration> selectRegByKey(RegistrationVo registrationVo) {
        return registrationMapper.selectRegByKey(registrationVo);
    }

    /*
     * @Author zhangyuanjie
     * @Description //TODO
     * @Date 16:11 2020/3/27
     * @Param [registrationVo]
     * @return java.util.List<com.zyj.hos.entity.Registration>
    **/
    @Override
    public List<Registration> selectRegPatByKey(RegistrationVo registrationVo) {
        return registrationMapper.selectRegPatByKey(registrationVo);
    }

    @Override
    public void updateStatusById(String registrationId) {
        registrationMapper.updateStatusById(registrationId);
    }

    @Override
    public List<Registration> selectAllReg() {
        return registrationMapper.selectAllReg();
    }

    @Override
    public List<Registration> selectRegMoreByKey(RegistrationVo registrationVo) {
        return registrationMapper.selectRegMoreByKey(registrationVo);
    }

    @Override
    public void timeOutReg() {
        registrationMapper.timeOutReg();
    }

    @Override
    public Integer selectTodayReg(Integer doctorId) {
        return registrationMapper.selectTodayReg(doctorId);
    }
}
