package org.qingfei.glee.controller;/**
 * Created by ASUS on 6/3/2018.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.qingfei.glee.service.MessageService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class MessageControllerTest {

    @Autowired
    private MessageService messageService;

    private MockMvc mvc;

    @InjectMocks
    private MessageController messageController;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() {
        //this.mvc = MockMvcBuilders.standaloneSetup(followController).build();
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPostSuccess() throws Exception {
        MockHttpServletResponse response =
                mvc.perform(post("/message/save")
                        .param("content","I love my job")
                        .param("username","jenny")
                        .param("userId","1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json("{success=0}"))
                .andReturn()
                .getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
    @Test
    public void testPostFail() throws Exception {
        MockHttpServletResponse response =
                mvc.perform(post("/message/save")
                        .param("content","I love my job"))
                        .andExpect(status().isOk())
                        .andDo(print())
                        .andExpect(content().json("{success=1}"))
                        .andReturn()
                        .getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }



}
