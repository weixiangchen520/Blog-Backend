package com.weixiangchen.blog.controller;

import com.weixiangchen.blog.domain.User;
import com.weixiangchen.blog.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
// @RestController = @Controller + @ResponseBody组成
// @Controller 将当前修饰的类注入SpringBoot IOC容器，使得从该类所在的项目跑起来的过程中，这个类就被实例化。当然也有语义化的作用，即代表该类是充当Controller的作用
// @ResponseBody 它的作用简短截说就是指该类中所有的API接口返回的数据，甭管你对应的方法返回Map或是其他Object，它会以Json字符串的形式返回给客户端
// 因为常规返回String会触发302跳转
@RestController
public class AuthController {
    // @Autowired和@Resources
    private final UserMapper userMapper;

    public AuthController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User currentUser = userMapper.findUserByEmailAndPassword(user);
        if (currentUser != null) {
            return "success";
        } else {
            return "fail";
        }
    }
}
