package mzl.jichu;

public class Test02{
	static int a = 0;
	int b = 1;
	public static void main(String[] args) {

		//		show(new Cat());
		//		show(new Dog());

//		Cat.D d = new Cat.D();
//		d.a();
		Cat.D d1 = new Cat.D();
		
		
		Cat c = new Cat();
		Cat.E e = c.new E();
		Cat.E e1 = new Cat().new E();
		

	}

	public static void show(Animal a) {
		a.eat();
		if(a instanceof Cat) {
			Cat c = (Cat)a;
			c.work();
		}else if(a instanceof Dog) {
			Dog f = (Dog)a;
			f.work();
		}
	}

	
}



abstract class Animal{
	abstract void eat();
}

class Cat extends Animal{
	Cat(){
		System.out.println("è�Ĺ�����");
	}
	public void eat() {
		System.out.println("����");
	}
	public void work() {
		System.out.println("ץ����");
	}
	
	public static class D{

		int dd = 0;
		public D() {
			System.out.println("ddddddddddd");
		}


	}
	
	class E{
		E(){
			System.out.println("eeeeeeeee");
		}
	}
}

class Dog extends Animal{
	public void eat() {
		System.out.println("�й�ͷ");
	}

	public void work() {
		System.out.println("����");
	}
}
