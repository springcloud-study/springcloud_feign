package com.zhihao.miao.user.controller;

import com.zhihao.miao.user.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;


@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/user,host:"+instance.getHost()+",service id:"+instance.getServiceId()+",port:"+instance.getPort());
        return "user index, local time="+ LocalDateTime.now();
    }

    @GetMapping("/hello")
    public String userHello() throws Exception{
        ServiceInstance serviceInstance = client.getLocalServiceInstance();
        //线程阻塞
        int sleeptime = new Random().nextInt(3000);
        logger.info("sleeptime:"+sleeptime);
        Thread.sleep(sleeptime);
        logger.info("/user,host:"+serviceInstance.getHost()+",service id:"+serviceInstance.getServiceId()+",port:"+serviceInstance.getPort());
        return "user hello";
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String username){
        return "hello "+username;
    }

    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    public User hello2(@RequestHeader String username,@RequestHeader Integer age){
        return new User(username,age);
    }

    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    public String hello3(@RequestBody User user){
        return "hello "+user.getUsername() +", "+user.getAge()+", "+user.getId();
    }
}
