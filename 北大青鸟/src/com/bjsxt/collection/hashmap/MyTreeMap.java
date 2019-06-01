package com.bjsxt.collection.hashmap;

import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 测试treemap
 * @author zhuhao
 * @date 2019年3月21日
 */
public class MyTreeMap {
	public static void main(String[] args) {
		TreeMap<Integer, String> tm = new TreeMap<>();
		tm.put(1, "11");
		tm.put(22, "1");
		tm.put(3, "13");
		tm.put(5, "15");
		tm.put(4, "14");
		
		System.out.println(tm);
		
		Entry<Integer, String> lastEntry = tm.lastEntry();
		System.out.println(lastEntry);
		Entry<Integer, String> firstEntry = tm.firstEntry();
		System.out.println(firstEntry);
		
		
	}
}
