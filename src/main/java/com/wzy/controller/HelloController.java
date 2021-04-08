package com.wzy.controller;

import com.wzy.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ApiOperation("hello测试")
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @ApiOperation("获得用户")
    @GetMapping("/getUser")
    public User getUser(User user){
        return user;
    }

}
