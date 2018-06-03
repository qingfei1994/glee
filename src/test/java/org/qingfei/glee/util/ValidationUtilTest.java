package org.qingfei.glee.util;/**
 * Created by ASUS on 6/3/2018.
 */

import org.junit.Test;
import org.qingfei.glee.entity.User;
import org.qingfei.glee.exception.GleeException;
import org.qingfei.glee.utils.ValidationUtil;

/**
 * Test for ValidationUtil
 *
 * @author Jenny Chen
 * @create 2018-06-03 5:12 PM
 */
public class ValidationUtilTest {

    @Test(expected = GleeException.class)
    public void testValidationFail() throws GleeException{
        User user = new User();
        ValidationUtil.validate(User.class,user);

    }

    @Test(expected = GleeException.class)
    public void testValidationFail2() throws GleeException {
        User user = new User();
        user.setUsername("");
        ValidationUtil.validate(User.class,user);
    }
    @Test
    public void testValidationSuccess() throws GleeException {
        User user = new User();
        user.setUsername("Jenny");
        ValidationUtil.validate(User.class, user);
    }
}
