package cn.kgc.demo02;

public class Dog implements Comparable<Dog>{
	
	private String name;
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public Dog(String name) {
		super();
		this.name = name;
	}



	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}



	@Override
	public int compareTo(Dog o) {
		return this.name.compareTo(o.getName());
	}

}
