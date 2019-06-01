package mzl.jichu;

public class Puppy {
	
	//成员变量
	private int age;
	
	
	//带一个参数的构造器，构造器的名称必须与类名相同
	public Puppy(String name) {
		System.out.println("小狗的名字为：" + name);
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void getAge() {
		System.out.println("小狗的年龄为：" + age);
	}
	
	public static void main(String[] args) {
		/* 创建对象*/
		Puppy myPuppy = new Puppy("虎子");
		//通过方法设定age
		myPuppy.setAge(8);
		//调用另一个方法取得age
		myPuppy.getAge();
		//也可以像下面这样访问类中的成员变量
		System.out.println("成员变量age为：" + myPuppy.age);
	}

}
