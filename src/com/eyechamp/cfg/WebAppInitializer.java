package com.eyechamp.cfg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.io.File;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final Logger LOGGER = LogManager.getLogger(WebAppInitializer.class.getName());

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        LOGGER.info("Starting EyeChamp");
        File file = new File("/eyechamp/config/eyechamp.properties");
        if(file.exists()){
            LOGGER.info("Property file /eyechamp/config/eyechamp.properties exists");
        }else{
            LOGGER.fatal("File /eyechamp/config/eyechamp.properties does not exist. Application can not be started");
        }
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{DispatcherConfig.class};
    }
}
