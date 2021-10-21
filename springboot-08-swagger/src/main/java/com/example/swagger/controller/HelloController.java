package com.example.swagger.controller;

import com.example.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @ApiOperation("Hello 方法")
    @GetMapping (value = "/hello")
    public String hello(){
        return "hello";
    }

    @ApiOperation("Hello2 方法")
    @GetMapping (value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello" + username;
    }

    @ApiOperation("Post 方法")
    @PostMapping (value = "/hello2")
    public User post(@ApiParam("用户名") User user){
        return user;
    }

    @ApiOperation("user 方法")
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

}
