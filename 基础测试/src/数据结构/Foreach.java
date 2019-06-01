package 数据结构;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Foreach {
	public static void main(String[] args) {

		ListTest lt = new ListTest();
		MapTest mt = new MapTest();

	}

}

class ListTest{
	List<String> list = new ArrayList<String>();

	ListTest(){
		list.add("Hello");
		list.add("World");
		list.add("HaHaHa");

		//第一种遍历方法
		for(String s : list) {
			System.out.println(s);
		}

		//第二种遍历方法
		String[] strArray = new String[list.size()];
		list.toArray(strArray);  //toArray()这个方法是转化数组类型的
		for(String s : strArray) {
			System.out.println(s);
		}

		//第三种使用迭代器遍历， 此种方法可以不用担心在遍历的过程中查超出集合的长度
		Iterator<String> ite = list.iterator();
		while(ite.hasNext()) {  //hasNext()判断是否还能取得元素
			System.out.println(ite.next());  //取出下一个元素
		}
	}
}

class MapTest{  //遍历map 的几种方法测试
	Map<String, String> map = new HashMap<String, String>();

	MapTest(){
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
        
		//第一种普遍使用，for的增强循环，二次取值
		System.out.println("//第一种普遍使用，for的增强循环，二次取值");
		for(String key : map.keySet()) {
			System.out.println(key + " --> " + map.get(key));
		}
		
		//第二种  标准写法
		System.out.println("//第二种  标准写法");
//		Set<?> entries = map.entrySet();  //entry.Set()返回一个set集合
//		if(entries != null) {
//			Iterator<?> ite = entries.iterator();
//			while(ite.hasNext()) {
//				Map.Entry entry = (Entry) ite.next();
//				Object key = entry.getKey();
//				Object value = entry.getValue();
//				System.out.println(key + " --> " + value);
//			}
//		}
		Iterator<?> ite = map.entrySet().iterator();
		while(ite.hasNext()) {
			Map.Entry<String, String> entry =   (Entry<String, String>) ite.next();
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}

		//第三种 力荐，尤其是容量比较大时
		System.out.println("//第三种 力荐");
		for(Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}
		
		//第四种方法
		System.out.println("通过Map.values()遍历所有的value，但是不能遍历key");
		for(String value : map.values()) {
			System.out.println("value --> " + value);
		}


	}
}
