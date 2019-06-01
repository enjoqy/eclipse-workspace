package com.train.keyword;

/**
 * static关键字
 * 		1.修饰类：只能修饰静态内部类。
 * 		2.修饰变量：即为类变量，使用方法：类名.变量名。
 * 		3.修饰方法：即为类方法，使用方法：类名.方法名（）。
 * 		4.方法的静态导入：将目标类中的静态方法导入为本类的静态方法。
 * @author zhuhao
 * @date 2019年3月5日
 */
public class Demo02Static {
	/**
	 * 内部类：
	 * 		1.可以被public修饰
	 * 		2.编译时，内部类生成单独的.class文件，命名格式为：外部类名$内部类名.class
	 * 		3.如果在方法中调用，必须用static修饰，即为内部类。
	 * @return 
	 */
	
	public static class Student {
		public String name = "内部类";
		public Student() {
			System.out.println(name);
			System.out.println("这个是内部类！");
		}
		
	}
	
	public static void main(String[] args) {
		new Student();
	}

}

class Teacher{
	//这个是外部类编译时会生成一个单独的.class文件，命名格式和外部类一样
}
