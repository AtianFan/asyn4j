package com.googlecode.asyn4j.core.handler;

import com.googlecode.asyn4j.core.work.AsynWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO Comment of DefaultErrorAsynWorkHandler
 * 
 * @author pan_java
 * @version DefaultErrorAsynWorkHandler.java 2010-8-27 下午07:56:56
 */
public class DefaultErrorAsynWorkHandler extends ErrorAsynWorkHandler {
    private static Logger log = LoggerFactory.getLogger(DefaultErrorAsynWorkHandler.class);

    @Override
    public void addErrorWork(AsynWork asynWork, Throwable throwable) {
        log.warn(asynWork.getThreadName() + " run is error, error info: " + throwable);
    }

}
