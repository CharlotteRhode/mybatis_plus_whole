package com.nodepower;


import com.nodepower.domain.User;
import com.nodepower.genderEnums.GenderEnums;
import com.nodepower.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TypeHandlerTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void handlerInsert(){ //从前端收到的map信息自动转换成json信息插入数据库
        User user = new User();
        user.setName("Kendall");
        user.setAge(30);
        user.setEmail("kendall@powernode.com");
        user.setGender(GenderEnums.WOMAN);
        user.setStatus(1);

        HashMap<String, String> map = new HashMap<>();
        map.put("tel","123456");
        map.put("addr", "USA");

        user.setContact(map);

        userMapper.insert(user);
    }

    @Test
    void handlerSelect(){
        List<User> resList = userMapper.selectList(null);
        System.out.println(resList);
    }





}
