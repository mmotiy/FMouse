package com.mmotiy.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmotiy.util.FileHander;


/**
 * @desr 服务启动过程中需要的配置参数
 * @author mmotiy
 *
 */
public class FMConfiguration {
	private Logger logger = LoggerFactory.getLogger(FMConfiguration.class);
	private Properties properties ;
	private static String CONFIG_LOCATION = "fm.config";
	/**
	 * 
	 * @param location 配置文件的绝对位置
	 */
	public FMConfiguration(String location) {
		this(new File(location));
	}
	public FMConfiguration(File location) {
		init(location);
	}
	public FMConfiguration(){
		this(FileHander.find(System.getProperties().get("user.dir").toString(), CONFIG_LOCATION));
	}
	
	private void init(File location) {
		this.properties = new Properties();
		try {
			logger.debug("loading config file {}",location);
			properties.load(new FileInputStream(location));
		} catch (FileNotFoundException e) {
			logger.error("config file was not found",e);
		} catch (IOException e) {
			logger.error("IOException",e);
		}
		System.out.println(properties);
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
}
