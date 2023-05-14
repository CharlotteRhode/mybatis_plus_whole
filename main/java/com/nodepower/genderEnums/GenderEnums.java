package com.nodepower.genderEnums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum GenderEnums {
    MAN(0,"男"), WOMAN(1, "女");

    @EnumValue //代表插入到数据库中的不再是整个枚举，而是这个枚举的这个属性
    private Integer genderId;
    private String genderName;


    GenderEnums(Integer genderId, String genderName) {
        this.genderId = genderId;
        this.genderName = genderName;
    }
}
