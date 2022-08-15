package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class Controller {
    @Autowired
    private MyDataSource source;

    @Value("${country}")
    private String country;

    @Value("${users.name}")
    private String name1;

    @Value("${users.age}")
    private String age;

    @Value("${tempDir}")
    private String tempDir;


    // 使用自动装配将所有的数据封装到一个对象Environment中
    @Autowired
    private Environment env;

    @GetMapping("/id")
    public String getById(){
        System.out.println(country);
        System.out.println("Springboot is running ………………");
        System.out.println("name========>"+name1);
        System.out.println("age========>"+age);
        System.out.println("tempDir========>"+tempDir);
        System.out.println("source========>"+source);
        System.out.println("env========>"+env.getProperty("tempDir"));
        return "Springboot is running………………";
    }

}
