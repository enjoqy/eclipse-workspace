package ����;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Fields {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//��ȡClass����
		Class clazz = Class.forName("����.Student");
		//��ȡ�ֶ�
		System.out.println("**************��ȡ���е��ֶ�****************");
		Field[] fieldArray = clazz.getFields();
		for(Field f : fieldArray) {
			System.out.println(f);
		}

		System.out.println("*****************��ȡ���еĹ������ֶ�**************");
		fieldArray = clazz.getDeclaredFields();
		for(Field f : fieldArray) {
			System.out.println(f);
		}
		
		/*
		 * �����ֶε�ֵ��
		 * 		Field --> public void set(Object obj,Object value):
		 * 					����˵����
		 * 					1.obj:Ҫ���õ��ֶ����ڵĶ���
		 * 					2.value:ҪΪ�ֶ����õ�ֵ
		 */
		System.out.println("************��ȡ���е��ֶ�**������****************");
		Field field = clazz.getField("name");  //�˷���ֻ�ܻ��public���ε�����
		System.out.println(field);
		//��ȡһ������
		Object obj = clazz.getConstructor().newInstance();  //����Student����--> Student stu = new Student();  ��ʱnew��һ��Student���󣬵�����һ���޲ι��췽��
		//Ϊ�ֶ���ֵ
		field.set(obj, "����");  
		Student stu = (Student)obj;
		System.out.println(stu.name);  //��֤name��ֵ�Ƿ�ı�
		
		System.out.println("**************��ȡ˽���ֶΣ����޸�*********");
		field = clazz.getDeclaredField("age");
		System.out.println(field);
		field.setAccessible(true);
		field.set(obj, 8888);
		System.out.println("��֤age�Ƿ�ı䣺" + stu);
	}

}
