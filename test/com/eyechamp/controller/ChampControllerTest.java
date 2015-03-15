package com.eyechamp.controller;

import com.eyechamp.cfg.ControllerTestContext;
import com.eyechamp.cfg.MVCConfig;
import com.eyechamp.repositories.PlayerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Michel on 25-2-2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerTestContext.class, MVCConfig.class})
@WebAppConfiguration
public class ChampControllerTest {
    private     MockMvc     mockMvc;

    @Autowired
    private PlayerRepository mockedPlayerRepository;

    @Autowired
    private     WebApplicationContext   webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(mockedPlayerRepository);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void addPlayerView() throws Exception{
        String name = "John Banana";
        when(mockedPlayerRepository.findByName(name)).thenReturn(null);

        mockMvc.perform(get("/player/add/{name}", name))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
    }
}
