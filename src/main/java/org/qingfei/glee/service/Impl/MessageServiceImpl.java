package org.qingfei.glee.service.Impl;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.entity.Message;
import org.qingfei.glee.repository.MessageRepository;
import org.qingfei.glee.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of MessageService
 *
 * @author Jenny Chen
 * @create 2018-05-30 5:44 PM
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    private Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Override
    @Cacheable(value = "messagecache")
    public List<Message> getMessageByUserId(Long userId) {
        return messageRepository.findByUserIdOrderByCreateTimestampDesc(userId);
    }

    @Override
    public boolean saveMessage(Message message) {
        Message msg = messageRepository.save(message);
        return msg != null;
    }

    @Override
    @Cacheable(value = "messagecache")
    public List<Message> findFriendMessage(long userId) {
        return messageRepository.findFriendMessage(userId);
    }

    @Override
    public Page<Message> list(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }
}
