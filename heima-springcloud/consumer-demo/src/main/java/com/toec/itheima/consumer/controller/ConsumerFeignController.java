package com.toec.itheima.consumer.controller;

import com.toec.itheima.consumer.client.UserClient;
import com.toec.itheima.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cf")
public class ConsumerFeignController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        return userClient.queryById(id);
    }
}
