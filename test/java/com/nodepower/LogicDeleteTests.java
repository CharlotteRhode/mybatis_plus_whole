package com.nodepower;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nodepower.domain.User;
import com.nodepower.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LogicDeleteTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void logicDelete(){ //实际上执行了update
        userMapper.deleteById(7L);
    }

    @Test
    void logicSelect(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }





}
