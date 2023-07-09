package com.jdc.dao.impl;

import com.jdc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String username, String password){
        if ("张三".equals(username)&&"123".equals(password)){
            return true;
        } else {
            return false;
        }
    }
}
