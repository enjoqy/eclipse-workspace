package 反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodClass {  //获取成员方法，并调用
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//获取class对象
		Class stu1Class = Class.forName("反射.Student01");

		/*
		 * 1.批量的：
		 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
		 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
		 */

		//获取所有方法
		System.out.println("*************获取所有的‘公有’方法，包含继承父类的方法**************");
		Method[] metArray = stu1Class.getMethods();  //此方法获取所有的public方法，父类的方法也可以获得，Object是最大的父类，自然也会获得
		for(Method m : metArray) {
			System.out.println(m);
		}

		System.out.println("*************获取所有的成员方法，包括私有的，但是不包含继承的*********************");
		metArray = stu1Class.getDeclaredMethods();
		for(Method m : metArray) {
			System.out.println(m);
		}

		/*
		 *  2.获取单个的：
		 * 		public Method getMethod(String name,Class<?>... parameterTypes):
		 * 					参数：
		 * 						name : 方法名；
		 * 						Class ... : 形参的Class类型对象
		 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
		 * 
		 */
		System.out.println("***********获取公有的show1方法*********");
		Method met = stu1Class.getMethod("show1", int.class);  //获得了show1方法
		System.out.println(met);
		Object obj = stu1Class.getConstructor().newInstance();  //相当于new了一个Student01的实例
		Student01 stu = (Student01)obj;
		//		Student01 stu = (Student01)obj;  //向下转型

		/*
		 * 
		 * 	 调用方法：
		 * 		Method --> public Object invoke(Object obj,Object... args):
		 * 					参数说明：
		 * 					obj : 要调用方法的对象；
                            args:调用方式时所传递的实参；
		 */
		met.invoke(obj, 6666);  //调用方法

	}

}
