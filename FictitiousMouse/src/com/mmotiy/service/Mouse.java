package com.mmotiy.service;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.mmotiy.dto.TagINPUT;
import com.mmotiy.util.FileHander;

public class Mouse {
	static final private Logger logger = LoggerFactory.getLogger(Mouse.class);
	
	static {
		try {
			String path = FileHander.find(System.getProperties().get("user.dir").toString(), "Mouse.dll").getCanonicalPath();
			System.load(path);
			logger.debug("加载dll文件:{}",path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ThreadPoolExecutor executor ;
	
	private class SendMsgThread extends Thread{
		private TagINPUT input;
		public SendMsgThread(TagINPUT input) {
			this.input = input;
		}
		@Override
		public void run() {
			logger.debug("接受到信号{}",JSON.toJSONString(input));
			Mouse.sendInput(input);
		}
	}
	
	
	public Mouse(ThreadPoolExecutor executor) {
		this.executor = executor;
	}
	public Mouse() {
		this.executor =  new ThreadPoolExecutor(10, 10, 3, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100));
	}
	
	public void mouse(TagINPUT input) {
		executor.execute(new SendMsgThread(input));

	}
	static public native void sendInput(TagINPUT input);
}
