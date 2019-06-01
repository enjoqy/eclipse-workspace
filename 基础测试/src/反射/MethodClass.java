package ����;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodClass {  //��ȡ��Ա������������
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//��ȡclass����
		Class stu1Class = Class.forName("����.Student01");

		/*
		 * 1.�����ģ�
		 * 		public Method[] getMethods():��ȡ����"���з���"���������˸���ķ���Ҳ����Object�ࣩ
		 * 		public Method[] getDeclaredMethods():��ȡ���еĳ�Ա����������˽�е�(�������̳е�)
		 */

		//��ȡ���з���
		System.out.println("*************��ȡ���еġ����С������������̳и���ķ���**************");
		Method[] metArray = stu1Class.getMethods();  //�˷�����ȡ���е�public����������ķ���Ҳ���Ի�ã�Object�����ĸ��࣬��ȻҲ����
		for(Method m : metArray) {
			System.out.println(m);
		}

		System.out.println("*************��ȡ���еĳ�Ա����������˽�еģ����ǲ������̳е�*********************");
		metArray = stu1Class.getDeclaredMethods();
		for(Method m : metArray) {
			System.out.println(m);
		}

		/*
		 *  2.��ȡ�����ģ�
		 * 		public Method getMethod(String name,Class<?>... parameterTypes):
		 * 					������
		 * 						name : ��������
		 * 						Class ... : �βε�Class���Ͷ���
		 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
		 * 
		 */
		System.out.println("***********��ȡ���е�show1����*********");
		Method met = stu1Class.getMethod("show1", int.class);  //�����show1����
		System.out.println(met);
		Object obj = stu1Class.getConstructor().newInstance();  //�൱��new��һ��Student01��ʵ��
		Student01 stu = (Student01)obj;
		//		Student01 stu = (Student01)obj;  //����ת��

		/*
		 * 
		 * 	 ���÷�����
		 * 		Method --> public Object invoke(Object obj,Object... args):
		 * 					����˵����
		 * 					obj : Ҫ���÷����Ķ���
                            args:���÷�ʽʱ�����ݵ�ʵ�Σ�
		 */
		met.invoke(obj, 6666);  //���÷���

	}

}
