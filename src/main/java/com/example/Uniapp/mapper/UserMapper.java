package com.example.Uniapp.mapper;

import com.example.Uniapp.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE account = #{account}")
    User findByAccount(String account);

    @Insert("INSERT INTO user(account, password, createtime) VALUES(#{account}, #{password}, #{createtime})")
    void insert(User user);
}
