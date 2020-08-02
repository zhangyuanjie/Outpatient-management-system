package com.zyj.hos.service.impl;

import com.zyj.hos.dao.UserMapper;
import com.zyj.hos.entity.User;
import com.zyj.hos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public List<User> selectUserByKey(User user) {
        return userMapper.selectUserByKey(user);
    }

    @Override
    public User selectUserByAccount(String userAccount) {
        return userMapper.selectUserByAccount(userAccount);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public String selectPwdById(Integer userId) {
        return userMapper.selectPwdById(userId);
    }

    @Override
    public void updatePwdById(User user) {
        userMapper.updatePwdById(user);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void insertUserByEmail(User user) {
        userMapper.insertUserByEmail(user);
    }

    @Override
    public void updatePwdByAccount(User user) {
        userMapper.updatePwdByAccount(user);
    }
}
