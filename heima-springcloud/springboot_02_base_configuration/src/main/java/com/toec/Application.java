package com.toec;

import com.alibaba.druid.pool.DruidDataSource;
import com.toec.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class)
public class Application {

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println(bean);
        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
        System.out.println(ds.getDriverClassName());
    }

}
