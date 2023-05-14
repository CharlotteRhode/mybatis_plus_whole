package com.nodepower;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nodepower.domain.User;
import com.nodepower.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.*;

@SpringBootTest
public class QueryTests {
    //-------------条件查询--------------------------

    @Autowired
    private UserMapper userMapper;

    @Test
    void equal() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "Hailey");
        User res = userMapper.selectOne(wrapper);
        System.out.println(res);
    }

    @Test
    void equal2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getAge, 100); //lambda方式可以防止写错
        User res = userMapper.selectOne(wrapper);
        System.out.println(res);
    }


    //如果条件为空，不作为判断条件，如果不为空，才拼接：
    @Test
    void judgeNull() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        String theName = null;
        wrapper.eq(theName != null, User::getName, theName);
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }


    //根据多个条件查询信息：
    @Test
    void multipleSearch() {
        HashMap<String, Object> hash = new HashMap<>();
        hash.put("name", "Hailey");
        hash.put("age", null);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(hash, false);

        User res = userMapper.selectOne(wrapper);
        System.out.println(res);
    }

    //如果条件不等于xx ,则展示：
    @Test
    void notThisOne() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.ne(User::getName, "Hailey");
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    //按照一个范围来查询：>
    @Test
    void rangeSearch() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        Integer theAge = 24;
        wrapper.gt(User::getAge, theAge);
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    // 范围查询： >=
    @Test
    void rangeSearch2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        Integer theAge = 24;
        wrapper.ge(User::getAge, theAge);
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    //范围查询 between and :
    @Test
    void rangeSearch3() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.between(User::getAge, 18, 35);
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    //模糊查询：like
    @Test
    void likeSearch() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, "h");
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    //模糊查询：left like
    @Test
    void leftLike() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.likeLeft(User::getName, "y");
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    // in:(age)
    @Test
    void inSearch() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 18, 24, 100);
        wrapper.in(User::getAge, arrayList);

        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    //灵活in:
    @Test
    void inSearch2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.inSql(User::getAge, "select age from user where age > 20");
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    //分组查询：groupBy
    @Test
    void groupSearch() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.groupBy("age");
        wrapper.select("age, count(*) as total");
        List<Map<String, Object>> resList = userMapper.selectMaps(wrapper);
        System.out.println(resList);
    }


    //分组查询：having
    @Test
    void havingSearch() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.groupBy("age");
        wrapper.select("age, count(*) as total ");
        wrapper.having("total = 1");
        List<Map<String, Object>> resList = userMapper.selectMaps(wrapper);
        System.out.println(resList);
    }


    //排序：order by
    @Test
    void orderSearch() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderBy(true, false, User::getAge);
        wrapper.orderBy(true, true, User::getId);
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }


    // 多条件查询 and
    @Test
    void andSearch() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(User::getAge, 24).lt(User::getAge, 500);
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    //多条件查询 - AND 嵌套：
    //select * from user where name = "Hailey" and (age > 20 or age < 500);
    @Test
    void andSearch2(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, "Hailey").and(i -> i.gt(User::getAge,20).or().lt(User::getAge, 400));

        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }



     //nest:
    @Test
    void nestMultiSearch(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.nested(i->i.eq(User::getName, "Hailey").ne(User::getAge, 20));
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    //limit:
    @Test
    void limitTest(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.last("limit 0, 3");
        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }

    //exist: 后半部分返回true , 才执行前半部分：
    @Test
    void existSearch(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.exists("select * from user where age = 1000");

        List<User> resList = userMapper.selectList(wrapper);
        System.out.println(resList);
    }





}
