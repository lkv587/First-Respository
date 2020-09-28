package com.example.awesome.service.impl;

import com.example.awesome.dao.UserMapper;
import com.example.awesome.pojo.dto.UserDTO;
import com.example.awesome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserById(Integer id) {
        int num = userMapper.getUserById(id);
        System.out.println(num);
        return null;
    }
}
