package com.jdc.service.impl;

import com.jdc.dao.UserDao;
import com.jdc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;
    @Override
    public void save(){
        userDao.save();
        System.out.println("调用了userService的save方法......");
    }
}
