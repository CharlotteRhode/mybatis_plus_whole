package com.nodepower;


import com.nodepower.domain.User;
import com.nodepower.genderEnums.GenderEnums;
import com.nodepower.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

@SpringBootTest
public class EnumTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void enumInsert(){
        User user = new User();
        user.setName("Chuck");
        user.setAge(40);
        user.setEmail("chuck@powernode.com");
        user.setStatus(1);
        user.setGender(GenderEnums.MAN);

        userMapper.insert(user);
    }





}
