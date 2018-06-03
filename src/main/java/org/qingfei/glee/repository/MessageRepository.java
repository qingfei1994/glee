package org.qingfei.glee.repository;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * CRUD operation of Message
 *
 * @author Chenhaiqing
 * @create 2018-05-30 4:51 PM
 */
@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message,Long> {

    List<Message> findByUserIdOrderByCreateTimestampDesc(Long userId);

    @Query("select message from Message message where message.userId in " +
            "(select followIdentity.friendId from Follow follow where followIdentity.followerId=:userId) " +
            "or message.userId=:userId order by message.createTimestamp desc")
    List<Message> findFriendMessage(@Param("userId")Long userId);

    Page<Message> findAll(Pageable pageable);


}
