package org.qingfei.glee.controller;/**
 * Created by ASUS on 6/2/2018.
 */

import org.qingfei.glee.entity.Message;
import org.qingfei.glee.entity.User;
import org.qingfei.glee.exception.GleeException;
import org.qingfei.glee.service.FollowService;
import org.qingfei.glee.service.MessageService;
import org.qingfei.glee.service.UserService;
import org.qingfei.glee.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller of the user home page
 *
 * @author Jenny Chen
 * @create 2018-06-02 2:38 PM
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FollowService followService;

    @Autowired
    private MessageService messageService;

    @RequestMapping("/greeting")
    public String login(User visitor, Model model) throws GleeException {
        ValidationUtil.validate(User.class,visitor);
        model.addAttribute("username",visitor.getUsername());
        User user = this.userService.saveOrGetUser(visitor);

        List<Message> messages = new ArrayList<>();
        List<Message> myPosts = null;
        messages = this.messageService.findFriendMessage(user.getId());
        myPosts = this.messageService.getMessageByUserId(user.getId());
        List<User> recommendUsers = this.followService.getUnFollowUserByFollowerId(user.getId());
        List<User> followUsers = this.followService.getFollowUserByFollwerId(user.getId());
        model.addAttribute("messages",messages);
        model.addAttribute("followCount",followUsers.size());
        model.addAttribute("posts",myPosts);
        model.addAttribute("user",user);
        model.addAttribute("recommends",recommendUsers);
        model.addAttribute("follows",followUsers);
        return "greeting";
    }


}
