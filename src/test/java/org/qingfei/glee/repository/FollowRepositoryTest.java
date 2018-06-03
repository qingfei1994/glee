package org.qingfei.glee.repository;/**
 * Created by ASUS on 6/3/2018.
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.qingfei.glee.entity.Follow;
import org.qingfei.glee.entity.FollowIdentity;
import org.qingfei.glee.entity.Message;
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
@SpringBootTest(classes = {FollowRepositoryTest.class})
@EntityScan("org.qingfei.glee.entity")
@EnableJpaRepositories("org.qingfei.glee.repository")
@DataJpaTest
public class FollowRepositoryTest {

    @Autowired
    private FollowRepository followRepository;

    private Logger logger = LoggerFactory.getLogger(FollowRepositoryTest.class);

    @Test
    public void testSaveFollow(){
        Follow follow = new Follow();
        FollowIdentity followIdentity = new FollowIdentity();
        followIdentity.setFollowerId(1L);
        followIdentity.setFollowerId(2L);
        follow.setFollowIdentity(followIdentity);
        Follow result = followRepository.save(follow);
        logger.info(result.toString());
        Assert.assertEquals(follow,result);
    }

    @Test
    public void testfindByFollowerId() {

        List<Follow> follows = followRepository.findByFollowerId(1L);
        for (Follow follow : follows) {
            logger.info(follow.toString());
        }
        Assert.assertNotNull(follows);
    }


}
