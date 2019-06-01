package com.bjsxt.collection.mylvector;

import java.util.Iterator;
import java.util.Vector;

import org.junit.Test;

/**
 * 测试Vector类的方法
 * 
 * @author zhuhao
 * @date 2019年3月19日
 */
public class DemoVector {
	
	@Test
	public void test01() {
		Vector v = new Vector();
		v.add("nijie");
		v.add("zhengyong");
		v.add("luoyueyang");
		
		//获取集合中元素的个数
		System.out.println(v.size());
		
		//获取指定索引处的元素
		System.out.println(v.get(1));
		
		//测试集合是否为空
		System.out.println(v.isEmpty());
		
		//测试内容是否存在
		System.out.println(v.contains("nijie"));
		
		//指定位置增加一个元素
		v.add(1, "222");
		System.out.println(v);
		Iterator iterator = v.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		
		//删除指定索引处的元素
		v.remove(1);
		System.out.println(v);
	}

}
