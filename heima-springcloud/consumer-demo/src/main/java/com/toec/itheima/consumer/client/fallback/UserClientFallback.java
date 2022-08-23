package com.toec.itheima.consumer.client.fallback;

import com.toec.itheima.consumer.client.UserClient;
import com.toec.itheima.consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户异常");
        return user;
    }
}
