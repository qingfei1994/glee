package org.qingfei.glee.service;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.entity.Follow;
import org.qingfei.glee.entity.User;

import java.util.List;

/**
 * Service Layer for Follow
 *
 * @author Chenhaiqing
 * @create 2018-05-30 5:33 PM
 */
public interface FollowService {

    List<Follow> getByFollowerId(Long followerId);

   boolean saveFollow(Follow follow);

    List<User> getUnFollowUserByFollowerId(Long followerId);

  List<User> getFollowUserByFollwerId(Long followerId);

}
