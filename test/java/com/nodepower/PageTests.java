package com.nodepower;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nodepower.domain.User;
import com.nodepower.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PageTests {

    @Autowired
    private UserMapper userMapper;


    //分页查询：
    @Test
    void getPages(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        IPage<User> eachPage = new Page<>(1, 3);
        userMapper.selectPage(eachPage, wrapper);
        System.out.println(eachPage.getRecords());
    }


    //自定义分页查询
    @Test
    void getPages2(){
        IPage<User> page = new Page<>(1, 2);
        userMapper.selectByName(page, "Hailey");

        System.out.println(page.getRecords());
    }


    //




}
