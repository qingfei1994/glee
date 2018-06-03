package org.qingfei.glee.service;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.entity.User;

/**
 * User Service
 *
 * @author Jenny Chen
 * @create 2018-05-30 6:08 PM
 */
public interface UserService {

    User findByUsername(String username);

    User saveUser(User user);

    User saveOrGetUser(User user);
}
