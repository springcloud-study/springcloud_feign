package com.zhihao.miao.pay.service;

import com.zhihao.miao.pay.bean.FullLogConfiguration;
import com.zhihao.miao.pay.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/21
 * @since 1.0
 *
 *
 */
//@FeignClient(value = "user-service",configuration = DisableHystrixConfigutation.class)
//@FeignClient(value = "user-service",fallback = UserServiceFallback.class)
@FeignClient(value = "user-service",configuration = FullLogConfiguration.class)
public interface UserService {

    @RequestMapping("/user/index")
    String index();

    @RequestMapping("/user/hello")
    String hello();

    @RequestMapping(value = "/user/hello1",method = RequestMethod.GET)
    String hello1(@RequestParam("username") String username);

    @RequestMapping(value = "/user/hello2",method = RequestMethod.GET)
    User hello2(@RequestHeader("username") String username, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/user/hello3",method = RequestMethod.POST)
    String hello3(@RequestBody User user);


}
