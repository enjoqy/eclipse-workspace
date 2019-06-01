package com.bjsxt.collection.myarraylist;

/** 测试泛型接口
 * @author zhuhao
 * @date   2019年3月7日
 * @param <T>
 */
public class StudentInterface<T> implements TestInterface<T>{  //T的类型由外部决定
	
	private T name;
	
	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public StudentInterface(T name) {
		this.name = name;
	}

	public StudentInterface() {
	}

	@Override
	public  T getname() {
		return this.name;
	}

	public static void main(String[] args) {
		TestInterface<String> student = new StudentInterface<String>("张三");
		System.out.println(student.getname());
	}
	
}
