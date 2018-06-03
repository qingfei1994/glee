package org.qingfei.glee.repository;/**
 * Created by ASUS on 6/3/2018.
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.qingfei.glee.entity.Message;
import org.qingfei.glee.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Test case for UserRepository
 *
 * @author Jenny Chen
 * @create 2018-06-03 2:25 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MessageRepositoryTest.class})
@EntityScan("org.qingfei.glee.entity")
@EnableJpaRepositories("org.qingfei.glee.repository")
@DataJpaTest
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository msgRepository;

    private Logger logger = LoggerFactory.getLogger(MessageRepositoryTest.class);

    @Test
    public void testSaveMessage(){
        Message message = new Message();
        message.setUserId(1L);
        message.setUsername("jenny");
        message.setContent("Hope when you take that jump,you don't feel the fall");
        Message result = msgRepository.save(message);
        Assert.assertEquals(message,result);
    }

    @Test
    public void testfindByUserId() {

        List<Message> messages = msgRepository.findByUserIdOrderByCreateTimestampDesc(1L);
        for (Message msg : messages) {
            logger.info(msg.toString());
        }
        Assert.assertNotNull(messages);
    }

    @Test
    public void findFriendMessage() {
        List<Message> messages = msgRepository.findFriendMessage(1L);
        for (Message msg : messages) {
            logger.info(msg.toString());
        }
        Assert.assertNotNull(messages);
    }

}
