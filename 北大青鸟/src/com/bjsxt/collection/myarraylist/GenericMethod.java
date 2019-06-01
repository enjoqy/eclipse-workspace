package com.bjsxt.collection.myarraylist;

/**
 * 测试泛型方法
 * 
 * @author zhuhao
 * @date   2019年3月7日
 */

public class GenericMethod {  //通用的一般方法

	public <Integer> void showSize(Integer o) {
		System.out.println(o.getClass().getName());
	}
	
	public GenericMethod() {
	}

	public static void main(String[] args) {
		GenericMethod gm = new GenericMethod();
		gm.showSize(10);
		
		GenericDemo<String,Integer> gd = new GenericDemo<String, Integer>("Jack", 23);
		gd.showType();
	}

}

class GenericDemo<T,V>{
	
	private T a;
	private V b;
	
	public GenericDemo(T a, V b) {
		this.a = a;
		this.b = b;
	}
	
	public void showType() {
		System.out.println("a的类型是： " + a.getClass().getName());
		System.out.println("b的类型是： " + b.getClass().getName());
	}
	
}
