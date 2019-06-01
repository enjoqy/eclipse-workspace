package com.train.keyword;

/**
 * final关键字：
 * 		1.修饰类：这个类不可以被继承。
 * 		2.修饰属性：即为常量。
 * 		3.修饰方法：该方法不能被重写，但是可以被重载。
 * 		4.修饰方法的形参：形参被赋值之后不能被改变。
 * 
 * @author zhuhao
 * @date 2019年3月5日
 */
public class Demo01Fianl {
	
	private final String NAME = "ALIBABA";
	
	public final void eat(final String food) {
//		food = "dd";  被final修饰过的形参的值不能被改变
		System.out.println("吃" + food);
	}
	
	public final void eat() {  //被final修饰的方法可以被重载，但是不可以被重写
		
	}
}
