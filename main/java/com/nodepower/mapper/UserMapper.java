package com.nodepower.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nodepower.domain.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {

        //自定义功能接口：根据name查询信息：
        User selectByName(String name); //-->去创建UserMapper接口的xml文件：


}
