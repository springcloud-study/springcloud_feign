package com.zhihao.miao.service;

import com.zhihao.miao.bean.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/22
 * @since 1.0
 */
@RequestMapping("/refactor")
public interface UserService {

    @RequestMapping(value = "/hello4",method = RequestMethod.GET)
    String hello1(@RequestParam("username") String username);

    @RequestMapping(value = "/hello5",method = RequestMethod.GET)
    User hello2(@RequestHeader("username") String username, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6",method = RequestMethod.POST)
    String hello3(@RequestBody User user);
}
