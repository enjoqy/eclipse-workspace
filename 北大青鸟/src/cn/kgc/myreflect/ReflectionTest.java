package cn.kgc.myreflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * Reflection。这个字的意思是“反射、映象、倒影”，用在Java身上指的是我们可以于运行时加载、探知、使用编译期间完全未知的classes
 * @author zhuhao
 * @date 2019年3月18日
 */
public class ReflectionTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		//方式一：通过Object类的getClass()方法取得，基本不用：
		Test01 ae = new Test01();
		Class<?> mClass = ae.getClass();
		System.out.println(mClass);
		
		//方式二：使用“类.class”取得，在日后学习Hibernate开发的时候使用
		Class a = Test01.class;
		System.out.println(a.getName());
		
		//方式三：使用Class类内部定义的一个static方法，主要使用·取得Class类对象：
		//public static Class<?> forName(String className) throws ClassNotFoundException；
		Class<?> cls = Class.forName("cn.kgc.myreflect.Test01");
		System.out.println(cls.getName());
		
		//通过反射实例化对象,相当于new关键字创建对象
		Class<?> cls1 = Class.forName("cn.kgc.myreflect.Test01");
		Test01 aut = (Test01) cls1.newInstance();
		System.out.println(aut.toString());
		
	}
	
	//取得一个类的全部构造：public Constructor<?>[] getConstructors() throws SecurityException
	@Test
	public void test01() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException {
		
		Class<?> cls = Class.forName("cn.kgc.myreflect.Test01");
		
		//返回此对象所包含类的所有public构造方法,私有的构造方法不能获取
		Constructor<?>[] cons = cls.getConstructors();
		for (Constructor<?> constructor : cons) {
			System.out.println(constructor);
		}
		System.out.println("----------------------");
		
		
		//返回此对象所包含类的所有的构造方法，与构造方法的访问级别无关
		Constructor<?>[] cons01 = cls.getDeclaredConstructors();
		for (Constructor<?> constructor : cons01) {
			System.out.println(constructor);
		}
		
	}
	
	//取得一个类的指定参数构造：public Constructor<T> getConstructor(Class<?>... parameterTypes) 
	//throws NoSuchMethodException, SecurityException
	@Test
	public void test02() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> cls = Class.forName("cn.kgc.myreflect.Test01");
		Constructor<?> cons = cls.getConstructor(String.class);
		Constructor<?> cons1 = cls.getConstructor(int.class);
		Test01 a = (Test01) cons1.newInstance();
		System.out.println(cons);
		System.out.println(cons1);
	}
	
	//用反射取得类的方法，并调用
	@Test
	public void test03() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> cls = Class.forName("cn.kgc.myreflect.Test01");
		Test01 t = (Test01) cls.newInstance();
		
		//取得实参是String类型的，名字是test的方法
		Method method = cls.getDeclaredMethod("test01", int.class);
		System.out.println(method + "\n");
		
		//调用invoke方法可以为方法赋值
		method.setAccessible(true);
		method.invoke(t, 0000);
		System.out.println(t);
		
		//取得类下面的所有public方法
		Method[] methods = cls.getMethods();
		for (Method method2 : methods) {
			System.out.println(method2 );
		}
		System.out.println();
		
		//取得类下面的所有方法，和方法的访问修饰符无关
		Method[] declaredMethods = cls.getDeclaredMethods();
		for (Method method2 : declaredMethods) {
			System.out.println(method2 );
		}
		System.out.println();
		
		
	}
	
	//用反射取得类的属性
	@Test
	public void test04() throws ClassNotFoundException {
		Class<?> cls = Class.forName("cn.kgc.myreflect.Test01");
		
		//取得类下面的所有public属性
		Field[] fields = cls.getFields();
		for (Field field : fields) {
			System.out.println(field );
		}
		System.out.println();
		
		
		//取得类下面的所有属性,和属性的访问修饰符无关
		Field[] declaredFields = cls.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field );
		}
	}
	
	//取得类的私有属性，并修改
	@Test
	public void test05() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<?> cls = Class.forName("cn.kgc.myreflect.Test01");
		Test01 t = (Test01) cls.newInstance();
		
		//取得的name的属性
		Field nameField = cls.getDeclaredField("name");
		//设置通过反射访问该field时取消权限检查，暴力
		nameField.setAccessible(true);
		nameField.set(t, "被爆破了");
		System.out.println(t);
		
		//取得的age的属性
		Field ageField = cls.getDeclaredField("age");
		//设置通过反射访问该field时取消权限检查，暴力
		ageField.setAccessible(true);
		ageField.setInt(t, 18);
		System.out.println(t);
		
		
		
	}
	
}
