package com.example.Uniapp.controller;

import com.example.Uniapp.bean.User;
import com.example.Uniapp.bean.WebResult;
import com.example.Uniapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userRegister")
    public WebResult userRegister(@RequestBody User user) {
        return userService.userRegister(user.getAccount(), user.getAccount());
    }

    @PostMapping("/userLogin")
    public WebResult login(@RequestBody User user) {
        return userService.UserLogin(user.getAccount(), user.getAccount());
    }
}
