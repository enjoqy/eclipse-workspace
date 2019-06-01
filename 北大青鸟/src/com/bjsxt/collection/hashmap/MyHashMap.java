package com.bjsxt.collection.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import javax.lang.model.element.NestingKind;

/**
 * 测试hashmap
 * @author zhuhao
 * @date 2019年3月20日
 */
public class MyHashMap {

	public static void main(String[] args) {
		
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(11, "111");
		hm.put(2, "112");
		hm.put(3, "113");
		hm.put(4, "114");
		
		//forEach遍历的一种方法
		hm.forEach((k,v) -> {
			System.out.println("k: " + k + "  v: " + v);
			if("2".equals(k)) {
				System.out.println("hello E");
			}
		});
		System.out.println("********************************");
		
		//Iterator遍历的一种方法
		Set<Integer> ks = hm.keySet();
		Iterator<Integer> iterator = ks.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			String string = hm.get(next);
			System.out.println("k: " + next + "  v: " + string);
		}
		System.out.println("********************************");
		
		//entrySet遍历的一种方法
		Set<Entry<Integer, String>> es = hm.entrySet();
		for (Entry<Integer, String> entry : es) {
			System.out.println("k: " + entry.getKey() + " v:  " + entry.getValue());
		}
	}
}
