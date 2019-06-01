package cn.kgc.myreflect;

public class Test01 {
	
	private String name;
	private int age;
	protected char sex;
	public String adress;
	
	private Test01(String name, int age, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public Test01( int age, char sex) {
		this.age = age;
		this.sex = sex;
	}
	
	public Test01(String name) {
		this.name = name;
	}
	
	public Test01() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	@Override
	public String toString() {
		return "Test01 [name=" + name + ", age=" + age + ", sex=" + sex + ", adress=" + adress + "]";
	}

	public void test(String name) {
		System.out.println("String " + name);
	}
	
	private void test01(int age) {
		System.out.println("int " + age);
	}

}
