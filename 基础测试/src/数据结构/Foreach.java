package ���ݽṹ;

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

		//��һ�ֱ�������
		for(String s : list) {
			System.out.println(s);
		}

		//�ڶ��ֱ�������
		String[] strArray = new String[list.size()];
		list.toArray(strArray);  //toArray()���������ת���������͵�
		for(String s : strArray) {
			System.out.println(s);
		}

		//������ʹ�õ����������� ���ַ������Բ��õ����ڱ����Ĺ����в鳬�����ϵĳ���
		Iterator<String> ite = list.iterator();
		while(ite.hasNext()) {  //hasNext()�ж��Ƿ���ȡ��Ԫ��
			System.out.println(ite.next());  //ȡ����һ��Ԫ��
		}
	}
}

class MapTest{  //����map �ļ��ַ�������
	Map<String, String> map = new HashMap<String, String>();

	MapTest(){
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
        
		//��һ���ձ�ʹ�ã�for����ǿѭ��������ȡֵ
		System.out.println("//��һ���ձ�ʹ�ã�for����ǿѭ��������ȡֵ");
		for(String key : map.keySet()) {
			System.out.println(key + " --> " + map.get(key));
		}
		
		//�ڶ���  ��׼д��
		System.out.println("//�ڶ���  ��׼д��");
//		Set<?> entries = map.entrySet();  //entry.Set()����һ��set����
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

		//������ �����������������Ƚϴ�ʱ
		System.out.println("//������ ����");
		for(Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}
		
		//�����ַ���
		System.out.println("ͨ��Map.values()�������е�value�����ǲ��ܱ���key");
		for(String value : map.values()) {
			System.out.println("value --> " + value);
		}


	}
}
