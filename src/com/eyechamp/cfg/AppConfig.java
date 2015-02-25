package com.eyechamp.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Michel on 21-2-2015.
 */
@Configuration
@ComponentScan("com.eyechamp")
@Import({DbConfig.class, MVCConfig.class})
public class AppConfig {
    //See imports
}
