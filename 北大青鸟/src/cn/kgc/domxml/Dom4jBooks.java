package cn.kgc.domxml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析books.xml
 * 
 * @author zhuhao
 * @date 2019年3月26日
 */
public class Dom4jBooks {

	public static void main(String[] args) throws DocumentException {

		// 1，创建SAXReader对象，用于读取xml文件
		SAXReader reader = new SAXReader();
		// 2，读取xml文件，得到Docu对象
		Document doc = reader.read(new File("src/books.xml"));
		// 3，获得根标签
		Element rootElement = doc.getRootElement();
		// 4，把根标签下的次一级标签进行迭代
		Iterator<Element> elementIterator = rootElement.elementIterator();
		while (elementIterator.hasNext()) {
			// 4.1获得次一级标签
			Element next = elementIterator.next();
			System.out.println(next.getName());
			// 4.2迭代获得次一级标签下的属性
			Iterator<Attribute> attributeIterator = next.attributeIterator();
			while (attributeIterator.hasNext()) {
				Attribute attribute = (Attribute) attributeIterator.next();
				System.out.println(attribute.getName() + "\t=\t" + attribute.getStringValue());
			}
			// 4.3迭代获得次一级标签下的标签
			Iterator<Element> elementIterator2 = next.elementIterator();
			while (elementIterator2.hasNext()) {
				Element element = (Element) elementIterator2.next();
				System.out.println(element.getName() + "\t=\t" + element.getStringValue());

			}
			System.out.println("-------------------");
		}
	}
}
