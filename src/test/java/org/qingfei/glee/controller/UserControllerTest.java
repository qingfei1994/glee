package org.qingfei.glee.controller;/**
 * Created by ASUS on 6/3/2018.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.qingfei.glee.service.FollowService;
import org.qingfei.glee.service.MessageService;
import org.qingfei.glee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test For UserController
 *
 * @author Jenny Chen
 * @create 2018-06-03 4:20 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FollowController.class})
@EntityScan("org.qingfei.glee.entity")
@ComponentScan(basePackages = "org.qingfei.glee")
public class UserControllerTest {
    @Autowired
    private FollowService followService;

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    private MockMvc mvc;

    @InjectMocks
    private FollowController followController;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() {
        //this.mvc = MockMvcBuilders.standaloneSetup(followController).build();
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testLoginSuccess() throws Exception {
        MockHttpServletResponse response =
                mvc.perform(get("/user/greeting?username=jenny"))
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testLoginFail() throws Exception {
        MockHttpServletResponse response =
                mvc.perform(get("/user/greeting"))
                        .andExpect(status().isBadRequest())
                        .andReturn()
                        .getResponse();
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }
}
