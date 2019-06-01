package com.bjsxt.collection.myarraylist;

public class Student implements Comparable{
	int id;
	String name;
	String gender;
	public Student() {
	}
	public Student(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public Student(int id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public int compareTo(Object o) {  //重写比较大小的方法
		Student student = (Student) o;
		//如果学号相同，那就是等于
		if(this.id == student.id) {
			return 0;
		}else if(this.getId() < student.getId()) {
			return -1;
		}else {
			return 1;
		}
	}

}
