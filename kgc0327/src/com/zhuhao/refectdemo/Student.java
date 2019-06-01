package com.zhuhao.refectdemo;

import java.io.Serializable;


/**
 * serizliazable,序列化联系
 * 
 * @author zhuhao
 * @date 2019年3月28日
 */

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	private void play() {
		System.out.println("我爱玩: "  + " 游戏");
	}

}
