package cn.kgc.demoimplements01;

public class FatherClass {
	
	private String name;
	
	public void test() {
		System.out.println("父类的test方法");
	}

	public FatherClass() {
		super();
	}

	public FatherClass(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FatherClass [name=" + name + "]";
	}
	
}
