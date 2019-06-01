package cn.kgc.myserializable;

import java.io.Serializable;

/**
 * 此类用来测试序列
 * 
 * @author zhuhao
 * @date 2019年3月18日
 */
public class Demo01 implements  Serializable {
	
	private String name;
	int age;
	protected char sex;
	
	
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Demo01() {
		// TODO Auto-generated constructor stub
	}
	public Demo01(String name, int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Demo01 [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
	

}
