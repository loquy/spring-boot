package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

// templates目录下所有页面只能通过控制器跳转，需要模板引擎支持
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg", "hello, spring boot");
        model.addAttribute("users", Arrays.asList("aslist","xx"));
        return "test";
    }
}
