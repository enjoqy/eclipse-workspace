package com.train;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

/**
 * Jsoup:
 * 		1.定义：用于解析html文件，如同xml解析器解析xml文件一样。代码风格与js、jQuery类似。
 * 		2.作用：
 * 			1.从URL、文件或字符串中获取并解析html。
 * 			2.查找和提取数据，使用dom遍历或css选择器直接选中节点。
 * 			3.操作html元素，修改标签的属性和文本。
 * 			4.输出整洁的html代码。
 * 			5.防止xss攻击，根据安全的白名单清理用户提交的内容。
 * 		3.开发指南：
 * 			https://www.open-open.com/jsoup/
 * 
 * @author junki
 * @date 2019年3月29日
 */
public class Demo01Jsoup {
	Document document = null;
	
	@Before
	public void test() throws IOException {
		File file = new File("./html/点名工具.html");
		document = Jsoup.parse(file, "utf-8");
	}
	
	@Test
	public void test1() throws IOException {

		
		//System.out.println(document);
		
		//Elements elements = document.getAllElements();
		
		//Elements elements = document.getElementsByTag("title");
		
		Element element = document.getElementById("name");
		
		System.out.println(element);
		
//		elements.forEach(x -> {
//			System.out.println(x);
//			System.out.println("==========================");
//		});
	}
	
	@Test
	public void test2() throws IOException {
		Elements elements = document.select("[id=\"start\"]");//css选择器查询
		System.out.println(elements.get(0));
	}
	
}
