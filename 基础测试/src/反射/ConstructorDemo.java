package ����;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo {  //Constructor������
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName("����.Student");
		
		System.out.println("********************ȡ�����й��еĹ��췽��*****************");
		Constructor[] conArray = clazz.getConstructors();
		for(Constructor<?> c : conArray) {
			System.out.println(c);
		}
		
		System.out.println("*******************ȡ�����й��췽��(����public,procted,deauflt,private)*********************");
		conArray = clazz.getDeclaredConstructors();  //declared�����ģ���Ȼ��
		for(Constructor<?> c : conArray) {
			System.out.println(c);
		}
		
		System.out.println("**************��ȡ���С��޲εĹ��췽��*********");
		Constructor<?> con = clazz.getConstructor(null);  //Ŀ��ֻ��ȡ�ù����ķ���
		System.out.println(con);
		
		Object obj = con.newInstance();
		System.out.println(obj);
		Student stu = (Student)obj;  //����ת��
		System.out.println(stu);
		
		System.out.println("*****************��ȡ˽�еĹ��췽��***************");
		con = clazz.getDeclaredConstructor(char.class);  //������������ͣ�����ȡ�������
		System.out.println(con);
		
		con.setAccessible(true);  //accessible�ѽӽ��ģ������ģ�����������飬��������˽�з���
		obj = con.newInstance('��');
	}

}
