package com.zhuhao.refectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.junit.Test;

/**
 * 测试反射
 * 
 * @author zhuhao
 * @date 2019年3月28日
 */
public class RefectDemo {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			ClassNotFoundException, NoSuchMethodException, SecurityException, NoSuchFieldException {

		// 1，第一种方法
		Student student = new Student();
		Class<? extends Student> class1 = student.getClass();

		// 2，第二种方法
//		Class<? extends Class> class2 = Student.class.getClass();
		Class<Student> student2 = Student.class;

		// 3，第三种方法
		Class<?> stClass = Class.forName("com.zhuhao.refectdemo.Student");
		Constructor<?> constructor = stClass.getConstructor();
		System.out.println(constructor);
		Constructor<?>[] declaredConstructors = stClass.getDeclaredConstructors();
		for (Constructor<?> constructor2 : declaredConstructors) {
			System.out.println(constructor2);

		}
		System.out.println();
		Method[] declaredMethods = stClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
		
		System.out.println();
		Field[] declaredFields = stClass.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field);
		}
		
		Student studet = (Student) stClass.newInstance();
		Field declaredField = stClass.getDeclaredField("name");
		declaredField.setAccessible(true);
		declaredField.set(studet, "11111111111111111");
		String name = declaredField.getName();
		System.out.println(studet);
		
	}
	
}
