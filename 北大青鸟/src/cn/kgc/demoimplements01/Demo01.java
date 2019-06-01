package cn.kgc.demoimplements01;

public class Demo01 {
	
	public static void main(String[] args) {
		
		//1.父子类继承多态
		FatherClass fc = new FatherClass();
		fc.test();
		
		FatherClass son01 = new Son01();
		son01.test();
		
		FatherClass son02 = new Son02();
		son02.test();
		
		//2.接口实现多态
		FatherInterface fi01 = new Son01();
		fi01.demo();
		
		FatherInterface fi02 = new Son02();
		fi02.demo();
		
		//3.多态转型
		/*A a1 = new B();
		a1.a();
		System.out.println(a1 instanceof B);
		System.out.println(a1 instanceof A);
		
		B b1 = new B();
		b1.a();
		b1.b();
		
		A a2 = b1;
		a2.a();
		System.out.println(a2 instanceof A);
		System.out.println(a2 instanceof B);
		
		A a3 = new A();
//		B b2 = (B) a3;  //可以编译，但是运行报错，不可强转
		*/
		
		B b = new B();//子类引用指向子类对象
		A a = b;//向上转型：父类 变量名 = 子类对象
		
		A a2 = new A();//父类引用指向父类对象
		System.out.println(a2 instanceof B);
		//B b2 = (B)a2;
		
		A a3 = new B();//父类引用指向子类对象
		a3.a();//父类引用只能调用父类声明过的方法
		//a3.b();//父类引用调用不了子类自己的方法
		
		System.out.println(a3 instanceof B);
		B b3 = (B)a3;//向下转型：子类 变量名 = (子类)父类对象
		
		b3.a();//子类引用可以执行父类方法
		b3.b();//子类引用也可以执行子类自己的方法
		
		
		
	}

}
