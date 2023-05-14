package com.nodepower;


import com.nodepower.domain.User;
import com.nodepower.genderEnums.GenderEnums;
import com.nodepower.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class AutoFillTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void autoInsert(){ //从前端收到的map信息自动转换成json信息插入数据库
        User user = new User();
        user.setName("Poppy");
        user.setAge(36);
        user.setEmail("polly@powernode.com");
        user.setGender(GenderEnums.WOMAN);
        user.setStatus(1);

        HashMap<String, String> map = new HashMap<>();
        map.put("tel","123465");
        map.put("addr", "CANADA");

        user.setContact(map);

        userMapper.insert(user);
    }


    @Test
    void autoUpdate(){
        User user = new User();
        user.setId(6L);
        user.setName("HaileyRhode");

        userMapper.updateById(user);
    }


}
