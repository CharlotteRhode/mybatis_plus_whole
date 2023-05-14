package com.nodepower.domain;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.nodepower.genderEnums.GenderEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.OrientationRequested;
import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user", autoResultMap = true) //如果数据库里的表名和idea里的实体类名称不一致的话，在这里写明表名称：
                                                  // varchar(json)->map
public class User extends Model<User> {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("name") //如果数据库里的column名称与实体类里的属性名不一致的话：
    private String name;
    private Integer age;
    private String email;
    @TableField(exist = false) //在实体类中有，但是数据库表中不存在的变量，指定sql语句不要拼接这一条
    private Integer online;
    //@TableLogic(value = "1", delval = "0") //逻辑删除
    private Integer status;

    private GenderEnums gender;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Map<String,String> contact; // 实体类的数据需要和数据库做对应，并且自动转换类型
                                        //map-> varchar(json), varchar->map

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    @Version
    private Integer version;


}
