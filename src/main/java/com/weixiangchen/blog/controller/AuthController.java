package com.weixiangchen.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weixiangchen.blog.domain.User;
import com.weixiangchen.blog.mapper.UserMapper;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.redis.core.RedisTemplate;
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
    private final RedisTemplate redisTemplate;

    public AuthController(UserMapper userMapper, RedisTemplate redisTemplate) {
        this.userMapper = userMapper;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, @RequestBody User user) {
        User currentUser = userMapper.findUserByEmailAndPassword(user);
        if (currentUser != null) {
//            ValueOperations ops = redisTemplate.opsForValue();
//            System.out.println(currentUser.getId());
//            System.out.println(JSON.toJSONString(currentUser));
//            System.out.println(ops.get(currentUser.getId().toString()));
//            ops.set(currentUser.getId().toString(), JSON.toJSONString(currentUser));
            HttpSession session = request.getSession();
            System.out.println(currentUser);
            session.setAttribute("info", currentUser);
            return "success";
        } else {
            return "fail";
        }
    }
}
