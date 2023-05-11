package com.nodepower.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user") //如果数据库里的表名和idea里的实体类名称不一致的话，在这里写明表名称：
public class User {
    private Long id;
    @TableField("name") //如果数据库里的column名称与实体类里的属性名不一致的话：
    private String name;
    private Integer age;

    @TableField(select = false)//执行查询时，不展示
    private String email;

    @TableField(exist = false) //在实体类中有，但是数据库表中不存在的变量，指定sql语句不要拼接这一条
    private Integer online;
}
