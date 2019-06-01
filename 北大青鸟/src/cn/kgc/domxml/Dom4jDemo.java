package cn.kgc.domxml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j解析xml文档
 * 
 * @author zhuhao
 * @date 2019年3月25日
 */
public class Dom4jDemo {

	public static void main(String[] args) throws DocumentException {

		// 1,创建SAXReader对象，用于读取xml文件
		SAXReader reader = new SAXReader();

		// 2,读取xml文件，得到Document对象
		Document doc = reader.read(new File("src/scores2.xml"));

		// 3,获取根元素
		Element rootElement = doc.getRootElement();

		// 4,获取根元素下的所有子元素
		Iterator<?> iterator = rootElement.elementIterator();
		while (iterator.hasNext()) {
			// 取出元素
			Element e = (Element) iterator.next();
			System.out.println(e.getName());
			// 获取id属性
			// Attribute id = e.attribute("id");
			// System.out.println(id);

			// 4.1迭代获取student中的属性
			Iterator<?> attributeIterator = e.attributeIterator();
			while (attributeIterator.hasNext()) {
				Attribute id = (Attribute) attributeIterator.next();
				System.out.println(id.getName() + " = " + id.getValue());
			}

			// 4.2迭代获取syudent下的子标签
			Iterator<?> iterator2 = e.elementIterator();
			while (iterator2.hasNext()) {
				Element id = (Element) iterator2.next();
				System.out.println(id.getName() + " = " + id.getStringValue());
			}
			System.out.println("----------------");
		}

	}

}
