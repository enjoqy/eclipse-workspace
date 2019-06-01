package org.zhh.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author zhuhao
 * @date 2019年5月29日
 */
public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	static {
		// 加载配置文件中的数据
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
			driver = properties.getProperty("driverClassName");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
