package mzl.jichu;

public class Puppy {
	
	//��Ա����
	private int age;
	
	
	//��һ�������Ĺ������������������Ʊ�����������ͬ
	public Puppy(String name) {
		System.out.println("С��������Ϊ��" + name);
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void getAge() {
		System.out.println("С��������Ϊ��" + age);
	}
	
	public static void main(String[] args) {
		/* ��������*/
		Puppy myPuppy = new Puppy("����");
		//ͨ�������趨age
		myPuppy.setAge(8);
		//������һ������ȡ��age
		myPuppy.getAge();
		//Ҳ���������������������еĳ�Ա����
		System.out.println("��Ա����ageΪ��" + myPuppy.age);
	}

}
