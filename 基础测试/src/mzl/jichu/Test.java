package mzl.jichu;

public class Test {
	public static void main(String[] args) {

		Integer i1 = 128; //�Զ�װ��
		Integer i2 = Integer.valueOf(128);

		int m1 = i1;  //�Զ�����
		int m2 = i2.intValue();
		
		Character ch = 'a';
		Character ch1 = new Character('b');

		System.out.println(i2);

		Integer j1 = 100;
		Integer j2 = 100;

		if(j1 == j2) {  //java��� -128~127 ֮����������л��棬���Զ��������������ʼֵλ��-128~127 ֮��ʱ����������ʹ����ͬһ����ַ
			             // ������Integer��������ֵ���� -128~127 ��Χʱ������ʹ���˲�ͬ�ĵ�ַ
			System.out.println("true  \"df\"    ");
		}else{
			System.out.println("false  \"df\" ");
		}
	}

}
