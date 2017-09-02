package com.googlecode.asyn4j.core.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO Comment of CallBackRejectedExecutionHandler
 * 
 * @author pan_java
 * @version CallBackRejectedExecutionHandler.java 2010-9-13 下午02:52:20
 */
public final class CallBackRejectedExecutionHandler implements RejectedExecutionHandler {

    private static Logger log = LoggerFactory.getLogger(CallBackRejectedExecutionHandler.class);

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        AsynCallBack asynCallBack = (AsynCallBack) r;
        log.warn(r + " not execute");
    }

}
