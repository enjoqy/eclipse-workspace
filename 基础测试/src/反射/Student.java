package 反射;

public class Student {
	
	public String name;
	public String name1;
	protected int age;
	double age1;
	char sex;
	private String phoneNum;
	
	public String toString() {
		return "name= " + name + " age= " + age + " sex= " + sex;
	}
	
	Student(int age){
		System.out.println("age = " + age);
	}
	public Student() {
		System.out.println("调用了无参构造" );
	}
	public Student(double dou) {
		System.out.println("调用了double类型的方法" + dou);
	}
	public Student(String name) {
		System.out.println("name = "+ name);
	}
	protected Student(String name, int age) {
		System.out.println("name =" + name + "age = "+ age);
	}
	private Student(char name) {
		System.out.println("name = " + name);
		
	}

}
