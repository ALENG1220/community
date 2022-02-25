package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fff
 * @create 2022-2-23 15:04
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public  User findUserById(int userId){
        return userMapper.selectById(userId);
    }
}
