package mzl.jichu.ȡֵ����;

public class PrimitiveTypeTest extends InstanceCounter {  //Primitive:ԭʼ��  Type:����
	
	private int a = 8;
	
	PrimitiveTypeTest ptt = new PrimitiveTypeTest();
	
	protected int getqz() {
//		return  a;
		return ptt.getCounter();
	}
	
	protected void setqz(int a) {
		this.a=a;

//		return;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		
		
		//Byte
		System.out.println("//Byte");
		System.out.println("�������ͣ�byte ������λ��: " + Byte.SIZE);
		System.out.println("��װ��java.lang.Byte");
		System.out.println("��Сֵ�� BYte.MIN_VALUE= " + Byte.MIN_VALUE);
		System.out.println("���ֵ�� BYte.Max_VALUE= " + Byte.MAX_VALUE);
		System.out.println();

		//Short
		System.out.println("//Short");
		System.out.println("�������ͣ�Short ������λ��: " + Short.SIZE);
		System.out.println("��װ��java.lang.Short");
		System.out.println("��Сֵ�� Short.MIN_VALUE= " + Short.MIN_VALUE);
		System.out.println("���ֵ��Short.Max_VALUE= " + Short.MAX_VALUE);
		System.out.println();

		//Int
		System.out.println("//Int");
		System.out.println("�������ͣ�int ������λ��: " + Integer.SIZE);
		System.out.println("��װ��java.lang.Integer");
		System.out.println("��Сֵ�� Integer.MIN_VALUE= " + Integer.MIN_VALUE);
		System.out.println("���ֵ��IntegerMax_VALUE= " + Integer.MAX_VALUE);
		System.out.println();

		//Long
		System.out.println("//Long");
		System.out.println("�������ͣ�Long ������λ��: " + Long.SIZE);
		System.out.println("��װ��java.lang.Long");
		System.out.println("��Сֵ�� Long.MIN_VALUE= " + Long.MIN_VALUE);
		System.out.println("���ֵ��LongMax_VALUE= " + Long.MAX_VALUE);
		System.out.println();

		//Float
		System.out.println("//Float");
		System.out.println("�������ͣ�Float ������λ��: " + Float.SIZE);
		System.out.println("��װ��java.lang.Float");
		System.out.println("��Сֵ�� Long.MIN_VALUE= " + Float.MIN_VALUE);
		System.out.println("���ֵ��LongMax_VALUE= " + Float.MAX_VALUE);
		System.out.println();

		//Double
		System.out.println("//Double");
		System.out.println("�������ͣ�Double ������λ��: " + Double.SIZE);
		System.out.println("��װ��java.lang.Double");
		System.out.println("��Сֵ�� Double.MIN_VALUE= " + Double.MIN_VALUE);
		System.out.println("���ֵ��DoubleMax_VALUE= " + Double.MAX_VALUE);
		System.out.println();

		//Char
		System.out.println("//Char");
		System.out.println("�������ͣ�Char ������λ��: " + Character.SIZE);
		System.out.println("��װ��java.lang.Character");
		System.out.println("��Сֵ�� Character.MIN_VALUE= " + (int)Character.MIN_VALUE);
		System.out.println("���ֵ��CharacterMax_VALUE= " + (int)Character.MAX_VALUE);
		System.out.println();
	}

}
