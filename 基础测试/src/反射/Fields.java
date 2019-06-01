package 反射;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Fields {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//获取Class对象
		Class clazz = Class.forName("反射.Student");
		//获取字段
		System.out.println("**************获取公有的字段****************");
		Field[] fieldArray = clazz.getFields();
		for(Field f : fieldArray) {
			System.out.println(f);
		}

		System.out.println("*****************获取所有的公共的字段**************");
		fieldArray = clazz.getDeclaredFields();
		for(Field f : fieldArray) {
			System.out.println(f);
		}
		
		/*
		 * 设置字段的值：
		 * 		Field --> public void set(Object obj,Object value):
		 * 					参数说明：
		 * 					1.obj:要设置的字段所在的对象；
		 * 					2.value:要为字段设置的值
		 */
		System.out.println("************获取公有的字段**并调用****************");
		Field field = clazz.getField("name");  //此方法只能获得public修饰的属性
		System.out.println(field);
		//获取一个对象
		Object obj = clazz.getConstructor().newInstance();  //产生Student对象--> Student stu = new Student();  此时new了一个Student对象，调用了一个无参构造方法
		//为字段设值
		field.set(obj, "张三");  
		Student stu = (Student)obj;
		System.out.println(stu.name);  //验证name的值是否改变
		
		System.out.println("**************获取私有字段，并修改*********");
		field = clazz.getDeclaredField("age");
		System.out.println(field);
		field.setAccessible(true);
		field.set(obj, 8888);
		System.out.println("验证age是否改变：" + stu);
	}

}
