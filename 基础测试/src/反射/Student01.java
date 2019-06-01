package 反射;

public class Student01 {
	public Student01(){
		System.out.println("调用了无参构造方法");
	}
	public void show1(int a ) {
		System.out.println("public  a = " + a);
	}
	protected void show2() {
		System.out.println("protected");
	}
	void show3() {
		System.out.println("deauflt");
	}
	private  String show4(String b) {
		System.out.println("private b =" + b);
		return b;
	}

}
