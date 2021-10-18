package com.example;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
        User ad = userService.queryUserByName("ad");
        System.out.println(ad);
    }

}
