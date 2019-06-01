package cn.kgc.myserializable;

import java.io.Serializable;

/**
 * 此类用来测试序列
 * 
 * @author zhuhao
 * @date 2019年3月18日
 */
public class Demo implements Serializable{
	
	//transient关键字可以阻止某些属性
	private transient String name;
	transient  int age;
	protected transient  char sex;
	
	
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
	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Demo(String name, int age, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Demo [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
	

}
