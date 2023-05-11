package com.nodepower.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.nodepower.domain.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectList();
}
