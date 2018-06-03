package org.qingfei.glee.controller;/**
 * Created by ASUS on 6/2/2018.
 */

import org.qingfei.glee.entity.Message;
import org.qingfei.glee.entity.User;
import org.qingfei.glee.exception.GleeException;
import org.qingfei.glee.service.FollowService;
import org.qingfei.glee.service.MessageService;
import org.qingfei.glee.utils.StringUtils;
import org.qingfei.glee.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller For Message
 *
 * @author Jenny Chen
 * @create 2018-06-02 10:33 PM
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private FollowService followService;

    @ResponseBody
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Map<String,Integer> saveMessage(Message msg) {
        Map<String,Integer> data = new HashMap<>();
        try {
            ValidationUtil.validate(Message.class,msg);
        } catch (GleeException e) {
            data.put("success",1);
            return data;
        }
        boolean isSaveSuccess = this.messageService.saveMessage(msg);

        if (isSaveSuccess) {

            data.put("success",0);
        } else {
            data.put("success",1);
        }
        return data;
    }

    @RequestMapping(value = "/list")
    public String listMessage(@RequestParam(name="page",defaultValue = "0") Integer page,
        @RequestParam(name = "pageSize",defaultValue = "4") Integer pageSize,User user, Model model) throws GleeException{

        if (user==null|| StringUtils.isBlank(user.getUsername())|| user.getId()==null) {
            throw new GleeException("error occur");
        }
        //Sort by createTimestamp desc
        Sort sort = new Sort(Sort.Direction.DESC,"createTimestamp");

        Pageable pageable = new PageRequest(page,pageSize,sort);
        Page<Message> messages = this.messageService.list(pageable);
        List<User> follows = this.followService.getFollowUserByFollwerId(user.getId());
        List<String> followUsernames = new ArrayList<>();
        for (User follow:follows) {
            followUsernames.add(follow.getUsername());
        }
        model.addAttribute("message",messages.getContent());
        model.addAttribute("page",messages);
        model.addAttribute("user",user);
        model.addAttribute("follows",followUsernames);
        return "message";
    }

}
