package com.toec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MsConfig {

    @Bean
    public String msg(){
        return "bean msg";
    }


}
