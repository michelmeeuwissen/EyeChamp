package com.eyechamp.cfg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Michel on 19-2-2015.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final Logger logger = LogManager.getLogger(WebAppInitializer.class.getName());

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.info("Starting EyeChamp");
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{DispatcherConfig.class};
    }
}
