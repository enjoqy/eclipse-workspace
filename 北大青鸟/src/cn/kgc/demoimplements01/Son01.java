package cn.kgc.demoimplements01;

public class Son01 extends FatherClass implements FatherInterface{
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void test() {
		System.out.println("Son01重写的父类方法");
	}
	
	@Override
	public void demo() {
		System.out.println("Son01实现的FatherInterface接口！");
	}

}
