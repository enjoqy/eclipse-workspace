package cn.kgc.domxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4jUser {
	
	public static void main(String[] args) throws IOException {
		
		Document doc = DocumentHelper.createDocument();
		
		Element Student = doc.addElement("Student");
		
		Student.addAttribute("id", "1");
		
		Element name = Student.addElement("name");
		Element age = Student.addElement("age");
		Element sex = Student.addElement("sex");
		
		name.addText("小花");
		age.addText("小明");
		sex.addText("小勇");
		
		OutputFormat createPrettyPrint = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileWriter(new File("Student.xml")), createPrettyPrint);
		
		xmlWriter.write(doc);
		xmlWriter.close();
		
		System.out.println("xml文件已生成");
		
	}
	
	

}
