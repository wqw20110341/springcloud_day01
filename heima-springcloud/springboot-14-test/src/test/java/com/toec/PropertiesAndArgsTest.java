package com.toec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

// 1. properties属性可以为当前测试用例添加临时的属性配置
//@SpringBootTest(properties = {"test.prop=testValue1"})
//@SpringBootTest(value = {"--test.prop=testValue2"})
@SpringBootTest(/*properties = {"test.prop=testValue1"},*/value = {"--test.prop=testValue2"})
public class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String msg;

    @Test
    public void testProperties(){
        System.out.println("==========="+msg);
    }

}
