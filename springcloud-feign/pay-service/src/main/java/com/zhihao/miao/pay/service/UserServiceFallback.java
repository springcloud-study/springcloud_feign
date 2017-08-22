package com.zhihao.miao.pay.service;

import com.zhihao.miao.pay.bean.User;
import org.springframework.stereotype.Component;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/22
 * @since 1.0
 */
//@Component
public class UserServiceFallback implements UserService{

    @Override
    public String index() {
        return "error";
    }

    @Override
    public String hello() {
        return "hello error";
    }

    @Override
    public String hello1(String username) {
        return "hello username is null";
    }

    @Override
    public User hello2(String username, Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello3(User user) {
        return "user error";
    }
}
