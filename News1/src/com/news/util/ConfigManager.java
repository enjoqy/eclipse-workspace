package com.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 读取数据库属性文件
 * @author Administrator
 *	使用单例模式
 *	1.构造私有化
 *	2.创建静态私有的本类实例
 *	3.提供静态公共方法，用于获得本类对象
 */
public class ConfigManager {
	String fileName = "db.properties";
	Properties properties = new Properties();
	
//	创建静态私有的本类实例 懒汉模式
//	private static ConfigManager configManager;
	
//	饿汉模式
	private static ConfigManager configManager = new ConfigManager();
	
//	构造私有化
	private ConfigManager(){
//		通过getResourceAsStream方法，将属性文件，读取到流中
		InputStream is = 
				ConfigManager.class.getClassLoader().getResourceAsStream(fileName);
		try {
//			使用properties对象，加载读取了属性文件后的流
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	提供静态公共方法，用于获得本类对象 懒汉模式
//	public static ConfigManager getConfigManager(){
//		if(configManager != null){
//			return configManager;
//		}else{
//			configManager = new ConfigManager();
//			return configManager;
//		}
//	}
	
//	饿汉模式
	public static ConfigManager getConfigManager(){
		return configManager;
	}
	
	public String getValue(String key){
//		通过key，来读取属性文件中的数据
		return properties.getProperty(key);
	}
}
