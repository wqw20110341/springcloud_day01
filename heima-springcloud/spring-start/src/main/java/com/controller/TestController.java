package com.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 折戟沉沙
 * @Description: 简书-演示
 * @Version: 1.0
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String testController(){
        return  "hello  ---  word?";
    }

    @RequestMapping(value = "/user/{id}" ,method =  RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        System.out.println("==========>"+id);
        return id+"成功";
    }
}