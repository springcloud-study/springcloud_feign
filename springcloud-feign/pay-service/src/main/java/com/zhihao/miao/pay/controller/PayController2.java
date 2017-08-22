package com.zhihao.miao.pay.controller;

import com.zhihao.miao.bean.User;
import com.zhihao.miao.pay.service.RefactorUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/22
 * @since 1.0
 */
@RestController
@RequestMapping("/pay2")
public class PayController2 {

    @Autowired
    RefactorUserService refactorUserService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello4(@RequestParam String username){
        return refactorUserService.hello1(username);
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello5(@RequestHeader String username, @RequestHeader Integer age){
        logger.info(age.getClass().getName());
        return refactorUserService.hello2(username,age);
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello6(@RequestBody User user){
        return refactorUserService.hello3(user);
    }
}
