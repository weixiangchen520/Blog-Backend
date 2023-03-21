package com.weixiangchen.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String index(@RequestParam(value = "userName", defaultValue = "Z") String userName) {
        String sql = "SELECT username FROM user WHERE username like ?";

        List<String> usernames = jdbcTemplate.queryForList(sql, new Object[]{ "%" + userName + "%" }, String.class);

        return "Hello " + usernames.toString();
    }

}
