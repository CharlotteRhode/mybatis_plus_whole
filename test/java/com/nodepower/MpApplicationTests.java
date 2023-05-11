package com.nodepower;

import com.nodepower.domain.User;
import com.nodepower.mapper.UserMapper;
import com.nodepower.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

@SpringBootTest
class MpApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //-------------test for Mapper-----------------------------------

    //查询全部信息
    @Test
    void selectAll() {
        List<User> res = userMapper.selectList(null);
        System.out.println(res);
    }

    //根据id查询信息：
    @Test
    void selectById(){
        User res = userMapper.selectById(6L);
        System.out.println(res);
    }

    //添加一条数据：
    @Test
    void insert(){
        User user = new User();//new一个对象出来
        user.setId(6L);
        user.setAge(34);
        user.setName("Hailey");
        user.setEmail("test@powernode.com");

        userMapper.insert(user);
    }

    //根据id删除：
    @Test
    void deleteOne(){
        userMapper.deleteById(6L);
    }

    //根据id修改：
    @Test
    void updateById(){
        User user = new User();
        user.setId(6l);
        user.setName("Hailey");
        user.setAge(35);
        user.setEmail("Hailey@powernode.com");

        userMapper.updateById(user);
    }

    //---------------------tests for Service-------------------------------

    //添加数据：
    @Test
    void serviceInsert(){
        User user = new User();
        user.setId(7L);
        user.setName("Lola");
        user.setAge(36);
        user.setEmail("lola@powernode.com");

        userService.save(user);
    }

    //根据id删除：
    @Test
    void serviceDelete(){
        userService.removeById(7L);
    }

    //根据id修改/更新：
    @Test
    void serviceUpdate(){
        User user = new User();
        user.setId(6L);
        user.setAge(100);

        userService.updateById(user);
    }

    //查询所有：
    @Test
    void serviceSelectAll(){
        List<User> res = userService.selectList();
        System.out.println(res);
    }

    //-----------------自定义功能的接口----------------------

    //自定义-根据name查询信息：
    @Test
    void customMethod1(){
        User res = userMapper.selectByName("Hailey");
        System.out.println(res);
    }








}
