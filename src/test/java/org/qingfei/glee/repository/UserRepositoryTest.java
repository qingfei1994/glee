package org.qingfei.glee.repository;/**
 * Created by ASUS on 6/3/2018.
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.qingfei.glee.entity.User;

import java.util.List;

/**
 * Test case for UserRepository
 *
 * @author Jenny Chen
 * @create 2018-06-03 2:25 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserRepositoryTest.class})
@EntityScan("org.qingfei.glee.entity")
@EnableJpaRepositories("org.qingfei.glee.repository")
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("Wendy");
        User result = this.userRepository.save(user);
        logger.info(result.toString());
        Assert.assertEquals("Wendy",user.getUsername());
    }

    @Test
    public void testfindByUsername() {

        User user = userRepository.findByUsername("jenny");
        logger.info(user.toString());
        Assert.assertEquals(1,user.getId().longValue());
    }

    @Test
    public void findUnFollowByFollowerId() {
        List<User> users = userRepository.findUnfollowByFollwerId(1L);
        Assert.assertNotNull(users);
    }

    @Test
    public void findFollowByFollowerId() {
        List<User> users = userRepository.findFollowbyFollowerId(1L);
        Assert.assertNotNull(users);
    }

}
