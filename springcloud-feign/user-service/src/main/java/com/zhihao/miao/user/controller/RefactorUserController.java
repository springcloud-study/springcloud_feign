package com.zhihao.miao.user.controller;

import com.zhihao.miao.bean.User;
import com.zhihao.miao.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/22
 * @since 1.0
 */
@RestController
public class RefactorUserController implements UserService{

    @Override
    public String hello1(@RequestParam String username) {
        return "user "+username;
    }

    @Override
    public User hello2(@RequestHeader("username")  String username, @RequestHeader("age") Integer age) {
        return new User(username,age);
    }

    @Override
    public String hello3(@RequestBody User user) {
        return "user "+user.getUsername()+", "+user.getAge();
    }
}

