package com.bjsxt.collection.hashmap;

/**
 * 实现map中的方法
 * 使用键值对的形式
 * @author zhuhao
 * @date 2019年3月5日
 */
public class MyMap {
	
	private SxtEntry[] arr = new SxtEntry[990];
	private int size;
	
	public void put(Object key, Object value) {  //增加一对键值对
		SxtEntry e = new SxtEntry(key,value);
		arr[size++] = e;
	}
	
	public Object get(Object key) { 
		for(int i=0; i<size; i++) {
			if((arr[i].getKey()).equals(key)) {
				return arr[i].getValue();
			}
		}
		return null;
	}
	
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		MyMap mm = new MyMap();
		mm.put("1111","22222");
		mm.put("333","444");
		mm.put("555","666");
		mm.put("777","888");
		
		System.out.println(mm.size());
		System.out.println(mm.get("555"));
		
	}
	
}

class SxtEntry{
	private Object key;
	private Object value;
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public SxtEntry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	public SxtEntry() {
	}
	
	
}
