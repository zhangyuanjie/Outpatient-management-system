package com.zyj.hos.service;

import com.zyj.hos.dao.UserMapper;
import com.zyj.hos.entity.User;

import java.util.List;

public interface UserService extends UserMapper {
    User selectUser(User user);
    List<User> selectAllUser();
    public List<User> selectUserByKey(User user);
    User selectUserByAccount(String userAccount);
    public void updateUserById(User user);
    public User selectUserById(Integer userId);
    public String selectPwdById(Integer userId);
    public void updatePwdById(User user);
    public void insertUser(User user);
    public void insertUserByEmail(User user);
    public void updatePwdByAccount(User user);
}
