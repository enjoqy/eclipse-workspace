package 反射;

public class Test_测试构造函数 {
	public static void main(String[] args) {
//		A a = new A();  //当没有无参构造的时候，创建对象的实例的时候就必须传入参数了
		A a = new A(2);
		System.out.println(a);
	}
	

}

class A{
	
	public String name = "dd";
	
	A(int a){  //当构造方法有参数的时候，无参构造方法就失效了
		System.out.println("调用了无参构造");
	}
	
	public String toString() {  //toString（）在打印类的实例的时候被打印
		return name;
	}
}
