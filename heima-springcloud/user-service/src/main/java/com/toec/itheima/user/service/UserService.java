package com.toec.itheima.user.service;

import com.toec.itheima.user.mapper.UserMapper;
import com.toec.itheima.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据主键查询用户
     * @param id 用户id
     * @return 用户
     */
    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
}
