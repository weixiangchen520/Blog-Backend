package com.weixiangchen.blog.controller;

import com.weixiangchen.blog.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import com.weixiangchen.blog.domain.User;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/info")
    public User info(@Param("id") Long id) {
        return userMapper.findUserById(id);
    }

    @GetMapping("/delete")
    public String delete(@Param("id") Long id) {
        userMapper.deleteUserById(id);
        return "test";
    }

    @PostMapping("/create")
    public Long create(@RequestBody User user) {
        userMapper.createUser(user);
        System.out.println(user.getId());
        return user.getId();
    }
}
