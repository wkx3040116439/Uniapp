package com.example.Uniapp.service.impl;

import com.example.Uniapp.bean.User;
import com.example.Uniapp.bean.WebResult;
import com.example.Uniapp.mapper.UserMapper;
import com.example.Uniapp.service.UserService;
import com.example.Uniapp.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public WebResult UserLogin(String account, String password) {
        WebResult webResult = new WebResult();
        try {
            User user = userMapper.findByAccount(account);
            if (user == null) {
                webResult.setCode(-2);
                webResult.setMessage("账号不存在");
            } else {
                if (PasswordEncoder.matches(password, user.getPassword())) {
                    webResult.setCode(0);
                    webResult.success("登录成功");
                } else {
                    webResult.setCode(-1);
                    webResult.error("密码错误");
                }
            }
        } catch (Exception ignored) {
            webResult.error("访问数据库出错");
        }
        return webResult;
    }
    @Override
    public WebResult userRegister(String account, String password) {
        WebResult webResult = new WebResult();
        try {
            User existingUser = userMapper.findByAccount(account);
            if (existingUser != null) {
                webResult.error(account + "账号已被注册");
            } else {
                User user = new User();
                user.setAccount(account);
                user.setPassword(PasswordEncoder.encode(password));
                user.setCreatetime(new Date());
                userMapper.insert(user);
                webResult.success("账号注册成功");
            }
        } catch (Exception exception) {
            webResult.error("访问数据库出错");
        }
        return webResult;
    }
}