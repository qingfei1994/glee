package org.qingfei.glee.config;/**
 * Created by ASUS on 5/31/2018.
 */



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.qingfei.glee.app.GleeApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.qingfei.glee.entity.User;

import java.util.concurrent.TimeUnit;

/**
 * Unit Test For Redis Config
 *
 * @author Jenny Chen
 * @create 2018-05-31 10:14 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {GleeApplication.class})
public class TestRedisConfig {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("jenny", "10");
        Assert.assertEquals("10",stringRedisTemplate.opsForValue().get("jenny"));
    }

    @Test
    public void testObj() throws InterruptedException {
        User user = new User();
        user.setId(20L);
        user.setUsername("Jackie");
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        operations.set("test1", user);
        operations.set("test2", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean isExist = redisTemplate.hasKey("test2");
        if (isExist) {
            System.out.println("test2 exists");
        } else {
            System.out.println("test2 does not exist");
        }
    }

}
