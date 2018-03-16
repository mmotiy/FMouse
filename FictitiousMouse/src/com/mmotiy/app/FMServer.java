package com.mmotiy.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.mmotiy.dto.TagINPUT;


public class FMServer {
	static private Logger logger = LoggerFactory.getLogger(FMServer.class);
	
	private volatile boolean running = true;
	private ServerSocket serverSocket;
	
	public FMServer() {
		
	}
	
	public void start(FMApp fmApp) {
		FMConfiguration configuration = fmApp.getConfiguration();
		try {
			this.serverSocket = new ServerSocket(Integer.valueOf((String) configuration.getProperties().get("server.port")));
			while(this.running) {
				Socket accept = serverSocket.accept();
				InputStream inputStream = accept.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
				String content = "";
				String result = "";
				while((content=br.readLine())!=null) {
					result+=content;
				}
				TagINPUT parseObject = JSON.parseObject(result, TagINPUT.class);
				fmApp.getMouse().mouse(parseObject);
			}
		} catch (IOException e) {
			logger.error("FMServer IOEXception",e);
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	
}
