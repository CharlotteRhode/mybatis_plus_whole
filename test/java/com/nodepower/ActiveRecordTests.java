package com.nodepower;

import com.nodepower.domain.User;
import com.nodepower.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.stream.events.ProcessingInstruction;


@SpringBootTest
public class ActiveRecordTests { //万事皆对象

    //增
   @Test
    void activeRecordAdd(){
       User user = new User();
       user.setName("Cora");
       user.setAge(28);
       user.setEmail("cora@powernode.com");

       user.insert();
   }

   //根据id 删除
    @Test
    void activeRecordDelete(){
        User user = new User();
        user.setId(1657640244574490625L);
        user.deleteById();
    }

    //根据id修改
    @Test
    void activeRecordUpdate(){
        User user = new User();
        user.setId(1657263050052362242L);
        user.setAge(500);

        user.updateById();
    }

    //根据id查询信息
    @Test
    void activeRecordSelect(){
        User user = new User();
        user.setId(5L);

        User res = user.selectById();
        System.out.println(res);
    }








}
