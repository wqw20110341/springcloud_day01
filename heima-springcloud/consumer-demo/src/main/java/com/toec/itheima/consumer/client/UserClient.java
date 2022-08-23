package com.toec.itheima.consumer.client;

import com.toec.itheima.consumer.pojo.User;
import com.toec.itheima.consumer.client.fallback.UserClientFallback;
import com.toec.itheima.consumer.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//声明当前类是一个Feign客户端，指定服务名为user-service
@FeignClient(value = "user-service", fallback = UserClientFallback.class,
configuration = FeignConfig.class)
public interface UserClient {

    //http://user-service/user/123
    @GetMapping("/user/{id}")
    User queryById(@PathVariable Long id);
}
