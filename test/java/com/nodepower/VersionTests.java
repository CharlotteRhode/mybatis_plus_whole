package com.nodepower;


import com.nodepower.domain.User;
import com.nodepower.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VersionTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void optimisticLockTest() { //模拟并发修改请求
        //2个人的查询操作
        User user1 = userMapper.selectById(6L);
        User user2 = userMapper.selectById(6L);
        //2个人的修改操作
        //1先改：
        user1.setName("HaileyR");
        userMapper.updateById(user1);

        //2后改：
        user2.setName("Cora");
        userMapper.updateById(user2);
    }




}
