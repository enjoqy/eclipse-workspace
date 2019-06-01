package com.bjsxt.collection.hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 测试map中常用的方法
 * @author zhuhao
 * @date 2019年3月5日
 */
public class TestMap {
	
	public static void main(String[] args) {
		Map m = new Hashtable();
		m.put(111, 222);
		m.put("xiaoming", "zhendiao");
		m.put("haohao", new Wife("刘亦菲"));
		m.put("zz", new Wife("ysn"));
		
		Wife w = (Wife) m.get("haohao");
		System.out.println(m.get("haohao"));
		m.remove("haohao");
		System.out.println(m.get("haohao"));
		System.out.println(w);
	}
	
	

}

class Wife{
	String name;

	public Wife(String name) {
		this.name = name;
	}

	public Wife() {
	}

	@Override
	public String toString() {
		return "Wife [name=" + name + "]";
	}
	
	
}


