package com.bjsxt.collection.myarraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * 测试Comparable比较器
 * @author zhuhao
 * @date   2019年3月7日
 */
public class DemoComparable {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		Student student1 = new Student(2,"李明", "男");
		Student student2 = new Student(1,"刘丽", "女");
		Student student3 = new Student();
		student3.setId(8);
		Student student4 = new Student();
		student4.setId(7);
		Student student5 = new Student();
		student5.setId(0);
		
		al.add(student1);
		al.add(student2);
		al.add(student3);
		al.add(student4);
		al.add(student5);
		
		Iterator it = al.iterator();
		while(it.hasNext()) {
			System.out.print(((Student) it.next()).getId() + "\t");
		}
		System.out.println();
		Collections.sort(al);
		it = al.iterator();  //再次使用迭代器需要再次调用iterator()方法
		while(it.hasNext()) {
			System.out.print(((Student) it.next()).getId()  + "\t");
		}
		System.out.println();
		System.out.println(student1.compareTo(student1));  //利用重写过的compareTo（）方法比较两个对象的id大小
		int index = Collections.binarySearch(al, student5);
		System.out.println("Student5的索引是： " + index);
	}
}
