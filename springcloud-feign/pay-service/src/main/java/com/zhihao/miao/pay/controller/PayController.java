package com.zhihao.miao.pay.controller;


import com.zhihao.miao.pay.bean.User;
import com.zhihao.miao.pay.service.RefactorUserService;
import com.zhihao.miao.pay.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/pay")
public class PayController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;



    @RequestMapping("/index")
    public String index(){
        return userService.index();
    }

    @RequestMapping("/hello")
    public String hello(){
        return userService.hello();
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello1(@RequestParam String username){
        return userService.hello1(username);
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello2(@RequestHeader String username,@RequestHeader Integer age){
        logger.info(age.getClass().getName());
        return userService.hello2(username,age);
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello3(@RequestBody User user){
        return userService.hello3(user);
    }




}
