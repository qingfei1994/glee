package org.qingfei.glee.controller;/**
 * Created by ASUS on 6/3/2018.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.qingfei.glee.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test For FollowController
 *
 * @author Jenny Chen
 * @create 2018-06-03 3:59 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FollowController.class})
@EntityScan("org.qingfei.glee.entity")
@ComponentScan(basePackages = "org.qingfei.glee")
public class FollowControllerTest {

    @Autowired
    private FollowService followService;

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
    public void testFollowSuccess() throws Exception {
        MockHttpServletResponse response =
                mvc.perform(get("/follow/save?followIdentity.followerId=2&followIdentity.friendId=3").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json("{success=0}"))
                .andReturn()
                .getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
    @Test
    public void testFollowFail() throws Exception {
        MockHttpServletResponse response =
                mvc.perform(get("/follow/save?followIdentity.friendId=3").contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andDo(print())
                        .andExpect(content().json("{success=1}"))
                        .andReturn()
                        .getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }



}
