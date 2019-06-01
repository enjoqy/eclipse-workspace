package 数据结构;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableDemo {  //哈希表练习，类似于Map
	public static void main(String[] args) {
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put("gdl", 2222);
		ht.put("fr", 1111);
		ht.put("sq", 3333);
		ht.put("chf", 44441);
		ht.put("cl", 555512333);
		ht.put("sqj", 666612);
		Enumeration<String> en = ht.keys();  //先取得key，再用key取得对应的value

		while(en.hasMoreElements()) {
			String str = (String) en.nextElement(); 
			System.out.println(str + "\t " + ht.get(str));
		}
		System.out.println();
		int aa = (ht.get("sqj")).intValue();
		ht.put("sqj", aa+10000000);
		System.out.println(ht.get("sqj"));
	}

}
