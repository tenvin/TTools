package com.twg.ttools.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringLifeCycle {
    private final static Logger LOGGER = LoggerFactory.getLogger(SpringLifeCycle.class);
    public void start(){
        LOGGER.info("SpringLifeCycle start");
    }


    public void destroy(){
        LOGGER.info("SpringLifeCycle destroy");
    }
}
