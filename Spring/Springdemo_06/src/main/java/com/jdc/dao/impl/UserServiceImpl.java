package com.jdc.dao.impl;

import com.jdc.dao.UserDao;
import com.jdc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean login(String username,String password){
        return userDao.login(username,password);
    }
}
