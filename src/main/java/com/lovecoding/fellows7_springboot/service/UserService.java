package com.lovecoding.fellows7_springboot.service;

import com.lovecoding.fellows7_springboot.pojo.User;

public interface UserService {
    User getUserById(Long id);

    int updateUser(User user);
}
