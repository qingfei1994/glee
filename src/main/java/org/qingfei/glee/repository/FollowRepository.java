package org.qingfei.glee.repository;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.entity.Follow;
import org.qingfei.glee.entity.FollowIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CRUD operation of Follow
 *
 * @author Chenhaiqing
 * @create 2018-05-30 4:41 PM
 */
@Repository
public interface FollowRepository extends JpaRepository<Follow,FollowIdentity> {


    @Query("select follow from Follow follow where followIdentity.followerId=?")
    List<Follow> findByFollowerId(Long followerId);

}
