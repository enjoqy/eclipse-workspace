package com.bjsxt.collection.hashmap;

import java.util.HashSet;

/**
 * 测试hashset
 * @author zhuhao
 * @date 2019年3月20日
 */
public class MyHashSet {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("1");
		hs.add("2");
		hs.add("dd");
		hs.add("4");
		hs.add("5");
		hs.add(null);
		
		//内部根据哈希码排序
		System.out.println(hs);
		
		
	}
}
