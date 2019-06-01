package 数据结构;

import java.util.Stack;

public class StackDemo {  //Stach栈 先进后出 练习
	
	static void showpush(Stack<Integer> st, int a) {  //放入一个元素
		st.push(new Integer(a));
		System.out.println("push ( " + a + " )");
		System.out.println("Stack: " + st);
	}
	
	static void showpop(Stack<Integer> st) {  //删除栈顶的元素，并返回这个值
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
