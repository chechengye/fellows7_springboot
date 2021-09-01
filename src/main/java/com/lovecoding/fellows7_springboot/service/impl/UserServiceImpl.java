package com.lovecoding.fellows7_springboot.service.impl;

import com.lovecoding.fellows7_springboot.mapper.UserMapper;
import com.lovecoding.fellows7_springboot.pojo.User;
import com.lovecoding.fellows7_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
