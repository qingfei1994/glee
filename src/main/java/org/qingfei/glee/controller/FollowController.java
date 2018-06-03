package org.qingfei.glee.controller;/**
 * Created by ASUS on 6/2/2018.
 */

import org.qingfei.glee.entity.Follow;
import org.qingfei.glee.service.FollowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller of Follow
 *
 * @author Jenny Chen
 * @create 2018-06-02 10:49 PM
 */
@Controller
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    private Logger logger = LoggerFactory.getLogger(FollowController.class);

    @ResponseBody
    @RequestMapping("/save")
    public Map<String,Integer> follow(Follow follow) {
        Map<String,Integer> data = new HashMap<>();
        logger.info(follow.toString());
        if (follow.getFollowIdentity()==null||follow.getFollowIdentity().getFollowerId()==null||follow.getFollowIdentity().getFriendId()==null) {
            data.put("success",1);
            return data;
        }
        boolean isSaveSuccess = this.followService.saveFollow(follow);
        if (isSaveSuccess) {
            data.put("success",0);
        } else {
            data.put("success",1);
        }
        return data;
    }
}

