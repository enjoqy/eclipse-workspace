package com.zhuhao.domxmldemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
/**
 * 讲对象存入map中，在从map中取出来输入到xml中
 * 
 * @author zhuhao
 * @date 2019年3月27日
 */
public class Dom4jStudent {
	
	public static void main(String[] args) throws IOException {
		
		Map<Integer, Student> map = new HashMap<>();
		
		//将数据存入map
		map.put(1, new Student("小小", 18, '女'));
		map.put(2, new Student("小二", 50, '男'));
		map.put(3, new Student("小三", 99, '女'));
		
		//生成document对象
		Document doc = DocumentHelper.createDocument();
		Element Students = doc.addElement("Students");
		
		//利用迭代将数据存入doc下的element中
		Set<Integer> keySet = map.keySet();
		for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
			
			int id = (int) iterator.next();
			
			Element student = Students.addElement("student");
			student.addAttribute("id", id + "");
			
			Element name = student.addElement("name");
			name.addText(map.get(id).getName());
			
			Element age = student.addElement("age");
			age.addText(map.get(id).getAge() + "");
			
			Element sex = student.addElement("sex");
			sex.addText(map.get(id).getSex() + "");
		}
		
		//格式化这个xml，并用流存入文件中,这个是使用默认的格式
		OutputFormat createPrettyPrint = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileWriter(new File("Student.xml")), createPrettyPrint);
		
		//关闭资源
		xmlWriter.write(doc);
		xmlWriter.close();
		
		//这个是自己设置格式
		OutputFormat createCompactFormat = OutputFormat.createCompactFormat();
		createCompactFormat.setEncoding("utf-8");  //gbk, gb2312
		createCompactFormat.setIndent(true);   //设置是否缩进
		createCompactFormat.setIndent("    ");  //以四个空格方式实现缩进
		createCompactFormat.setNewlines(true);  //设置是否换行
		
		XMLWriter xmlWriter2 = new XMLWriter(new FileWriter(new File("Student1.xml")), createCompactFormat);
		xmlWriter2.write(doc);
		xmlWriter2.close();
		
		
		System.out.println("xml文件已生成");
		
		
	}
	
	

}
