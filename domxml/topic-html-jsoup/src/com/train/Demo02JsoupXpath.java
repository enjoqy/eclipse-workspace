package com.train;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.seimicrawler.xpath.JXDocument;

/**
 * JsoupXpath
 * 
 * @author junki
 * @date 2019年3月29日
 */
public class Demo02JsoupXpath {
	
	@Test
	public void test() throws IOException {
		
		JXDocument jxDocument = JXDocument.createByUrl("http://www.xiaohuar.com/2014.html");
		List<Object> list = jxDocument.sel("//*[@id=\"list_img\"]//img");
		
		//list.forEach(System.out::println);
		
		for (Object object : list) {
			String node = object.toString();
			String name = node.substring(node.indexOf("alt=\"") + 5, node.indexOf("\" src=\""));
			//System.out.println(name);
			
			String url = node.substring(node.indexOf("src=\"") + 5, node.indexOf("\">"));
			if (!url.contains("http")) {
				url = "http://www.xiaohuar.com" + url;
			}
			//System.out.println(url);
			
			FileUtils.copyURLToFile(new URL(url), new File("./img/"+name+".jpg"));
			System.out.println(name+"爬取完毕。");
			
		}
		
	}
	
}
