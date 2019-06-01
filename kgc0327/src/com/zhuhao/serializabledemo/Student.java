package com.zhuhao.serializabledemo;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * serizliazable,序列化联系
 * 
 * @author zhuhao
 * @date 2019年3月28日
 */

@Data
@Builder
public class Student implements Serializable{

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
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
