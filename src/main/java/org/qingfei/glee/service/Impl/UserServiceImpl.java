package org.qingfei.glee.service.Impl;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.entity.User;
import org.qingfei.glee.repository.UserRepository;
import org.qingfei.glee.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Implementation of UserService
 *
 * @author Jenny Chen
 * @create 2018-05-30 6:10 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Cacheable(value="user-key")
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    @Cacheable(value = "usercache")
    public User saveOrGetUser(User user) {
        User result = userRepository.findByUsername(user.getUsername());
        if (result==null) {
            result = this.userRepository.save(user);
        }
        return result;
    }
}
