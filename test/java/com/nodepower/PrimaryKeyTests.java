package com.nodepower;

import com.nodepower.domain.User;
import com.nodepower.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrimaryKeyTests {

    @Autowired
    private UserMapper userMapper;


    //主键自增：跟随数据库的设置 - 自动
    @Test
    void primaryKeyAuto(){
        User user = new User();
        user.setName("Casper");
        user.setAge(36);
        user.setEmail("casper@powernode.com");

        userMapper.insert(user);
    }

    //input:必须手工set ID- 数据库里必须取消自增功能

    //雪花算法assigned-id :
    @Test
    void primaryKeySnow(){
        User user = new User();
        user.setName("Lola");
        user.setAge(37);
        user.setEmail("lola@powernode.com");

        userMapper.insert(user);
    }


}
