package com.bjsxt.collection.hashmap;

import java.util.LinkedHashSet;

/**
 * 测试linkedhashset
 * @author zhuhao
 * @date 2019年3月20日
 */
public class MyLinkedHashSet {
	
	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		
		//元素不可以重复，如果重复会覆盖上一个
		lhs.add("11");
		lhs.add("2");
		lhs.add("11");
		lhs.add("3");
		lhs.add("4");
		lhs.add("5");
		lhs.add("6");
		lhs.add("7");
		
		System.out.println(lhs);
		
		
	}
}
