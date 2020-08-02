package com.zyj.hos.dao;

import com.zyj.hos.entity.User;

import java.util.List;

public interface UserMapper {
    public User selectUser(User user);
    public List<User> selectAllUser();
    public List<User> selectUserByKey(User user);
    public User selectUserByAccount(String userAccount);
    public void updateUserById(User user);
    public User selectUserById(Integer userId);
    public String selectPwdById(Integer userId);
    public void updatePwdById(User user);
    public void insertUser(User user);
    public void insertUserByEmail(User user);
    public void updatePwdByAccount(User user);
}
