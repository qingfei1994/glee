package org.qingfei.glee.repository;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CRUD operation of User
 *
 * @author Chenhaiqing
 * @create 2018-05-30 4:45 PM
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    @Query("select user from User user where user.id not in " +
            "(select followIdentity.friendId from Follow follow where followIdentity.followerId=:followerId) " +
            "and user.id!=:followerId")
    List<User> findUnfollowByFollwerId(@Param("followerId")Long followerId);

    @Query("select user from User user where user.id in " +
            "(select followIdentity.friendId from Follow follow where followIdentity.followerId=:followerId)")
    List<User> findFollowbyFollowerId(@Param("followerId")Long followerId);
}
