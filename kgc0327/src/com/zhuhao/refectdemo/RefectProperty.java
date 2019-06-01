package com.zhuhao.refectdemo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射的应用
 * 		根据配置文件中的类名和方法名，执行指定类的指定方法
 * 
 * @author zhuhao
 * @date 2019年3月28日
 */
public class RefectProperty {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		//根据当前类所在项目下的路径，获取properties文件  //相对路径：推荐使用
		InputStream is = RefectProperty.class.getClassLoader().getResourceAsStream("classinfo.properties");
		
		Properties properties = new Properties();
		properties.load(is);
		
		//取得properties中的属性
		String methodName = properties.getProperty("methodName");
		String className = properties.getProperty("className");
		
		
		Class<?> clazz = Class.forName(className);
		Object newInstance = clazz.newInstance();
		Method declaredMethod = clazz.getDeclaredMethod(methodName);
		declaredMethod.setAccessible(true);
		declaredMethod.invoke(newInstance);
		
		is.close();
	}
}
