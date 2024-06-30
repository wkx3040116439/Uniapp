package com.example.Uniapp.service;

import com.example.Uniapp.bean.WebResult;

import java.util.List;

public interface UserService {
    WebResult UserLogin(String account, String password);
    WebResult userRegister(String account, String password);

}
