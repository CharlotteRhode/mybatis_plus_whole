package com.nodepower;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.nodepower.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.transform.Source;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootTest
public class SimpleQueryTests {
//先对某段信息进行操作，然后再获取：在查询的过程中就进行操作，再获取改变后的结果，一体化；不用
    //先获取，再操作

    //只拿某一段信息：拿到hailey的id:
    @Test
    void simpleQueryList(){
        List<Long> res = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Hailey"), User::getId);
        System.out.println(res);
    }

    //拿到Hailey, 把首字母变小写:
    @Test
    void simpleQueryTest2(){
        List<String> resList = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Hailey"), User::getName, new Consumer<User>() {
            @Override
            public void accept(User user) {
                Optional.of(user.getName()).map(String::toLowerCase).ifPresent(user::setName);
            }
        });

        System.out.println(resList);
    }

    // 把所有查询结果封装成一个map集合
    @Test
    void simpleQueryMap(){
        Map<Long, User> resList = SimpleQuery.keyMap(new LambdaQueryWrapper<User>(), User::getId);
        System.out.println(resList);
    }

    //自己设计key and value:
    @Test
    void simpleQueryMap2(){
        Map<String, Integer> resList = SimpleQuery.map(new LambdaQueryWrapper<User>(), User::getName, User::getAge);
        System.out.println(resList);
    }

    //分组：group
    @Test
    void simpleQueryGroup(){
        Map<Integer, List<User>> resList = SimpleQuery.group(new LambdaQueryWrapper<User>(), User::getAge);
        System.out.println(resList);
    }




}
