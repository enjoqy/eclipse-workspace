package com.bjsxt.collection.myarraylist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 测试hashmap
 * @author zhuhao
 * @date   2019年3月7日
 */
public class DemoHashMap {

	public static void main(String[] args) {
		Map<String,Student> m = new HashMap<String, Student>();
		Student student1 = new Student(1,"李明", "男");
		Student student2 = new Student(2,"刘丽", "女");
		m.put("Jack", student1);
		m.put("Rose", student2);
		System.out.println("已添加：" + m.size());
		System.out.println(m.keySet());
		System.out.println(m.values());
		Iterator<?> it = m.entrySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println(m.entrySet());
	}

}

