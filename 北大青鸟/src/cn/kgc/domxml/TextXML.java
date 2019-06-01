package cn.kgc.domxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 创建一个xml文件
 * 
 * @author zhuhao
 * @date 2019年3月26日
 */
public class TextXML {

	public static void main(String[] args) throws IOException {
		// 1,通过DocumentHelper生成一个Document对象
		Document doc = DocumentHelper.createDocument();
		// 2,添加一个根元素
		Element root = doc.addElement("school");
		// 3,为根元素添加子元素
		Element student = root.addElement("student");
		// 4,为student元素添加属性
		student.addAttribute("id", "1");
		student.addAttribute("score", "59.8");
		// 5，为student元素添加子元素
		Element name = student.addElement("name");
		Element age = student.addElement("age");// 迭代大動干戈過過
		Element sex = student.addElement("sex");
		// 6，为子元素添加文本信息
		name.addText("郑勇");
		age.addText("66");
		sex.addText("妖");
		// 7，将doc输出到xml文件即可,简单输出
		// Writer writer = new FileWriter(new File("src/school.xml"));
		// doc.write(writer);
		// System.out.println("文件输出成功！");
		// writer.close();
		// 7，格式良好输出
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter(new File("src/school.xml")), format);
		writer.write(doc);
		writer.close();
		System.out.println("文件输出成功！");
	}

}
