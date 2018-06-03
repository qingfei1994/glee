package org.qingfei.glee.controller;/**
 * Created by ASUS on 6/2/2018.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for index page
 *
 * @author Jenny Chen
 * @create 2018-06-02 2:51 PM
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
