package com.nodepower.controller;

import com.nodepower.domain.User;
import com.nodepower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/selectList")
    public List<User> selectList(){
        return userService.selectList();
    }
}
