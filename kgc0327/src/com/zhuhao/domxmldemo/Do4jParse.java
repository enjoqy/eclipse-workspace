package com.zhuhao.domxmldemo;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 将xml中的文件解析出来
 * 
 * @author zhuhao
 * @date 2019年3月27日
 */
public class Do4jParse {
	
	public static void main(String[] args) throws DocumentException {
		
		//创建map对象
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		Integer key = new Integer(0);
		Student value = new Student();
		String name = "";
		int age = 0;
		char sex = '0';
		
		//生成doc对象
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new File("Student.xml"));
		
		//取得根元素，遍历根元素下的属性和标签
		Element rootElement = doc.getRootElement();
		Iterator<Element> elementIterator = rootElement.elementIterator();
		
		
		while (elementIterator.hasNext()) {
			
			Element student = (Element) elementIterator.next();
			System.out.println(student.getName());
			
			//遍历student的属性
			Iterator<Attribute> attributeIterator = student.attributeIterator();
			while (attributeIterator.hasNext()) {
				Attribute id = (Attribute) attributeIterator.next();
				System.out.println(id.getName() + "\t=\t" + id.getStringValue());
				
				key = key.parseInt(id.getStringValue());  //接收id
			}
			
			//遍历student下的标签
			Iterator<Element> elementIterator2 = student.elementIterator();
			while (elementIterator2.hasNext()) {
				
				Element element = (Element) elementIterator2.next();
				System.out.println(element.getName() + "\t=\t" + element.getStringValue());
				
				//接收Student的属性
				if("name".equals(element.getName())) {
					name = element.getStringValue();
				}
				if("age".equals(element.getName())) {
					age = (int)new Integer(0).parseInt(element.getStringValue());
				}
				if("sex".equals(element.getName())) {
					sex = element.getStringValue().charAt(0);
				}
				
			}
			
			//将得到的数值都放到map中
			map.put(key, new Student(name, age, sex));
			
			System.out.println("----------------------");
		}
		
		//打印map，检测是否放入成功
		System.out.println(map);
		
	}

}
