package com.bjsxt.collection.myarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * @author zhuhao
 * @date   2019年3月7日
 */
public class DemoArrayList {
	public static void main(String[] args) {
//		ArrayList<String> al = new ArrayList<String>();
		//如果要安全的list：可以调用这个方法
		List<String> al = Collections.synchronizedList(new LinkedList());
		al.add("张三丰");
		al.add("郭靖");
		al.add("杨过");
		for(int i=0; i<al.size(); i++) {
			System.out.print(al.get(i) + "\t");
		}
		System.out.println("111111111111");
		al.forEach(d -> System.out.print(d + "\t"));
		System.out.println();
		System.out.println(al.contains("小龙女"));
		al.remove("0");
		al.set(1, "黄蓉");
		System.out.println(al.indexOf("黄蓉"));

		for (Object object : al) {
			System.out.print(object + "\t");
		}
		System.out.println();

		Iterator<String> it  = al.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "\t");
		}
		System.out.println();

		//使用fill（）方法替换集合中的全部元素
		Collections.fill(al, "东方不败");
		it = al.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "\t");
		}
		System.out.println();

		//清楚集合中的全部元素
//		al.clear();
		System.out.println( "al集合中的元素是否为空："+al.isEmpty());
		
		Object[] str =  al.toArray();
		for (Object st : str) {
			System.out.print(st + "\t");
		}
		System.out.println("*********");
	}
	
	@Test
	public void test01() {
		LinkedList ll = new LinkedList<>();
		
		ll.add("zhengyong");
		ll.add("luoyueyang");
		ll.add("zhangtao");
		
		System.out.println(ll);
		
		ll.addFirst("11");
		
		
		
		System.out.println(ll);
		
		System.out.println(ll.get(0));
	}
}
