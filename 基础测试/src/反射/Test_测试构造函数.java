package ����;

public class Test_���Թ��캯�� {
	public static void main(String[] args) {
//		A a = new A();  //��û���޲ι����ʱ�򣬴��������ʵ����ʱ��ͱ��봫�������
		A a = new A(2);
		System.out.println(a);
	}
	

}

class A{
	
	public String name = "dd";
	
	A(int a){  //�����췽���в�����ʱ���޲ι��췽����ʧЧ��
		System.out.println("�������޲ι���");
	}
	
	public String toString() {  //toString�����ڴ�ӡ���ʵ����ʱ�򱻴�ӡ
		return name;
	}
}
