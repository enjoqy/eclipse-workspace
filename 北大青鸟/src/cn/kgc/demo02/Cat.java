package cn.kgc.demo02;

public class Cat {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}
	
	
}
