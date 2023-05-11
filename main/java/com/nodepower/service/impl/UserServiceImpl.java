package com.nodepower.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nodepower.domain.User;
import com.nodepower.mapper.UserMapper;
import com.nodepower.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectList() {
        return userMapper.selectList(null);
    }
}
