package org.qingfei.glee.service.Impl;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.entity.Follow;
import org.qingfei.glee.entity.User;
import org.qingfei.glee.repository.FollowRepository;
import org.qingfei.glee.repository.UserRepository;
import org.qingfei.glee.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of FollowService
 *
 * @author Chenhaiqing
 * @create 2018-05-30 5:37 PM
 */
@Service("FollowService")
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(value="followcache")
    public List<Follow> getByFollowerId(Long followerId) {
        return followRepository.findByFollowerId(followerId);
    }

    @Override
    public boolean saveFollow(Follow follow) {
        Follow result = this.followRepository.save(follow);
        return result!=null;
    }

    @Override
    public List<User> getUnFollowUserByFollowerId(Long followerId) {
        return userRepository.findUnfollowByFollwerId(followerId);
    }

    @Override
    public List<User> getFollowUserByFollwerId(Long followerId) {
       return userRepository.findFollowbyFollowerId(followerId);
    }
}
