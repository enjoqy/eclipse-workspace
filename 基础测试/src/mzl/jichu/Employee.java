package mzl.jichu;

public class Employee {  //employee:雇员

	private  String name = "小三";
	private int age;
	private String designation;  //designation：任命;指派;名称
	private double salary;  //salary：薪水
	
	//Employee构造器，设置名字
	public Employee(String name) {
		this.name = name;
	}
	//设置年龄
	public void empAge(int age) {
		this.age=age;
	}
	//设置职位
	public void empDesignation(String designation) {
		this.designation=designation;
	}
	//设置薪水
	public void empSalary(double salary) {
		this.salary=salary;
	}
	//打印信息
	public void printEmployee() {
		System.out.println("名字： " + name);
		System.out.println("年龄: " + age);
		System.out.println("职位: " + designation);
		System.out.println("薪水: " + salary);
	}
}
