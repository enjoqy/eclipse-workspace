package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo {  //Constructor构造器
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName("反射.Student");
		
		System.out.println("********************取得所有共有的构造方法*****************");
		Constructor[] conArray = clazz.getConstructors();
		for(Constructor<?> c : conArray) {
			System.out.println(c);
		}
		
		System.out.println("*******************取得所有构造方法(包括public,procted,deauflt,private)*********************");
		conArray = clazz.getDeclaredConstructors();  //declared公共的，公然的
		for(Constructor<?> c : conArray) {
			System.out.println(c);
		}
		
		System.out.println("**************获取公有、无参的构造方法*********");
		Constructor<?> con = clazz.getConstructor(null);  //目测只能取得公共的方法
		System.out.println(con);
		
		Object obj = con.newInstance();
		System.out.println(obj);
		Student stu = (Student)obj;  //向下转型
		System.out.println(stu);
		
		System.out.println("*****************获取私有的构造方法***************");
		con = clazz.getDeclaredConstructor(char.class);  //传入参数的类型，即可取得这个类
		System.out.println(con);
		
		con.setAccessible(true);  //accessible已接近的，可理解的，，，跳过检查，暴力访问私有方法
		obj = con.newInstance('男');
	}

}
