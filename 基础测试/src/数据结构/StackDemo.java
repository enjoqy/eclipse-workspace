package ���ݽṹ;

import java.util.Stack;

public class StackDemo {  //Stachջ �Ƚ���� ��ϰ
	
	static void showpush(Stack<Integer> st, int a) {  //����һ��Ԫ��
		st.push(new Integer(a));
		System.out.println("push ( " + a + " )");
		System.out.println("Stack: " + st);
	}
	
	static void showpop(Stack<Integer> st) {  //ɾ��ջ����Ԫ�أ����������ֵ
		System.out.print("pop->");
		Integer a = (Integer)st.pop();
		System.out.println(a);
		System.out.println(st);
	}
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		System.out.println(st);
		showpush(st, 11);
		showpush(st, 12);
		showpush(st, 13);
		showpop(st);
		showpop(st);
		showpop(st);
		try {
			showpop(st);
		} catch (Exception e) {
			System.out.println("empty stack");
		}
	}

}
