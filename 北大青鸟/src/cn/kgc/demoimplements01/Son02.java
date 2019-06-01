package cn.kgc.demoimplements01;

public class Son02 extends FatherClass implements FatherInterface{
	
	@Override
	public void test() {
		System.out.println("Son02重写的父类方法");
	}

	@Override
	public void demo() {
		System.out.println("Son02实现的FatherInterface接口");
	}
	
}
