package com.toec.toec.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 分页操作是在MyBatisPlus的常规操作基础上增强得到，内部是动态的拼写SQL语句，
 * 因此需要增强对应的功能，使用MyBatisPlus拦截器实现
 * */
@Configuration
public class MPConfig {

    /**
     *  1.定义Mp拦截器
     *  2.添加具体的栏献思
     * */
    @Bean
    public MybatisPlusInterceptor mybitsPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return  interceptor;
    }

}
