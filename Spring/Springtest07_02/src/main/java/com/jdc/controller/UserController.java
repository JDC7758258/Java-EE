package com.jdc.controller;

import com.jdc.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userController")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;
    public void save(){
        userService.save();
        System.out.println("调用了userController的save方法......");
    }
}
