package com.eyechamp.cfg;

import com.eyechamp.repositories.PlayerRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Michel on 25-2-2015.
 */
@Configuration
@ComponentScan("com.eyechamp.controller")
public class ControllerTestContext {

    @Bean
    public PlayerRepository playerRepository(){
        return Mockito.mock(PlayerRepository.class);
    }
}
