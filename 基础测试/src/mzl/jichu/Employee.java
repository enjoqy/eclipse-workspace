package mzl.jichu;

public class Employee {  //employee:��Ա

	private  String name = "С��";
	private int age;
	private String designation;  //designation������;ָ��;����
	private double salary;  //salary��нˮ
	
	//Employee����������������
	public Employee(String name) {
		this.name = name;
	}
	//��������
	public void empAge(int age) {
		this.age=age;
	}
	//����ְλ
	public void empDesignation(String designation) {
		this.designation=designation;
	}
	//����нˮ
	public void empSalary(double salary) {
		this.salary=salary;
	}
	//��ӡ��Ϣ
	public void printEmployee() {
		System.out.println("���֣� " + name);
		System.out.println("����: " + age);
		System.out.println("ְλ: " + designation);
		System.out.println("нˮ: " + salary);
	}
}
