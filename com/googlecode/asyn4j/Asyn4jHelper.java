package com.googlecode.asyn4j;

import com.googlecode.asyn4j.core.callback.AsynCallBack;
import com.googlecode.asyn4j.core.handler.CacheAsynWorkHandler;
import com.googlecode.asyn4j.core.handler.DefaultErrorAsynWorkHandler;
import com.googlecode.asyn4j.core.handler.FileAsynServiceHandler;
import com.googlecode.asyn4j.service.AsynService;
import com.googlecode.asyn4j.service.AsynServiceImpl;

/**
 * Created with IntelliJ IDEA.
 * User: chenjing
 * Date: 2016/12/1
 * Time: 9:55
 */
public class Asyn4jHelper {

    private static AsynService anynService =null;

    static {
        // 初始化异步工作服务
        anynService = AsynServiceImpl.getService(300, 3000L, 100, 100,1000);
        //异步工作缓冲处理器
        anynService.setWorkQueueFullHandler(new CacheAsynWorkHandler(100));
        //服务启动和关闭处理器
        anynService.setServiceHandler(new FileAsynServiceHandler());
        //异步工作执行异常处理器
        anynService.setErrorAsynWorkHandler(new DefaultErrorAsynWorkHandler());
        // 启动服务
        anynService.init();
    }

    public static Asyn4jHelper getInstance() {
        return Asyn4jHelperHolder.instance;
    }
    private static class Asyn4jHelperHolder {
        private static Asyn4jHelper instance = new Asyn4jHelper();
    }

    public void asyn(Object targetServiceObj,String methodName,Object[] params,AsynCallBack acb){
        anynService.addWork(targetServiceObj,methodName,params,acb);
    }
}
