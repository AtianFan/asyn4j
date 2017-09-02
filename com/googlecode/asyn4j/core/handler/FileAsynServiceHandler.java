package com.googlecode.asyn4j.core.handler;

import com.googlecode.asyn4j.core.WorkProcessor;
import com.googlecode.asyn4j.core.work.AsynWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * TODO Comment of DefauleCloseHandler
 * 
 * @author pan_java
 * @version DefauleCloseHandler.java 2010-8-27 下午07:41:03
 */
public class FileAsynServiceHandler extends AsynServiceHandler {

	private static Logger log = LoggerFactory.getLogger(FileAsynServiceHandler.class);

	private static String asynDataFilePath="/asynwork.data";

	static {
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("win")){
			asynDataFilePath="C://asynwork.data";
		}
	}

	@Override
	public void init() {
		try {
			InputStream input =  new FileInputStream(new File(asynDataFilePath));
			ObjectInputStream oi = new ObjectInputStream(input);
			List<AsynWork> asynWorkList = (List<AsynWork>) oi.readObject();
			
			for(AsynWork asynWork:asynWorkList){
				this.asynService.addAsynWork(asynWork);
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	@Override
	public void destroy(){
		try {
			OutputStream out =  new FileOutputStream(new File(asynDataFilePath));
			ObjectOutputStream oo = new ObjectOutputStream(out);
			List<AsynWork> list = new ArrayList<AsynWork>();
			Iterator<Runnable> asynIterator = asynWorkQueue.iterator();
			
			while(asynIterator.hasNext()){
				list.add(((WorkProcessor)asynIterator.next()).getAsynWork());
			}
			oo.writeObject(list);
		} catch (Exception e) {
		    
		}
		System.out.println("asyn work have " + asynWorkQueue.size() + " no run!");
	    System.out.println("call back have " + callBackQueue.size() + " no run!");
    }
}