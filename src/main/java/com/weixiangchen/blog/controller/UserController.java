package com.weixiangchen.blog.controller;

import com.alibaba.fastjson.JSON;
import com.weixiangchen.blog.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public User info(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("info"));
        User currentUser = (User)session.getAttribute("info");
        return currentUser;
    }

    @GetMapping("/getInfoById")
    public User getUserInfoById( @Param("id") Long id) {
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
        return user.getId();
    }
}
