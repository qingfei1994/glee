package org.qingfei.glee.service;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * Message Service
 *
 * @author Jenny Chen
 * @create 2018-05-30 5:41 PM
 */
public interface MessageService {

    List<Message> getMessageByUserId(final Long userId);

    boolean saveMessage(Message message);

    List<Message> findFriendMessage(long userId);

    Page<Message> list(Pageable pageable);
}
