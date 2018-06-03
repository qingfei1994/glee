package org.qingfei.glee.service;/**
 * Created by ASUS on 5/31/2018.
 */


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.qingfei.glee.app.GleeApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.qingfei.glee.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Unit Test For UserServiceImpl
 *
 * @author Jenny Chen
 * @create 2018-05-31 10:36 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {GleeApplication.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
    @Test
    public void testFindUserByName() throws InterruptedException {
        User user = userService.findByUsername("jenny");
        logger.info("id of jenny is " + user.getId());
        logger.info("===================================");
        Thread.sleep(1000);
        User jenny = userService.findByUsername("jenny");
        logger.info("id of jenny is " + jenny.getId());
        Assert.assertEquals(user.getId(),jenny.getId());
    }
}
