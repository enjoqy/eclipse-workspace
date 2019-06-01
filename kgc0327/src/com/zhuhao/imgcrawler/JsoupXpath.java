package com.zhuhao.imgcrawler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.seimicrawler.xpath.JXDocument;

public class JsoupXpath {

	@Test
	public void test() throws IOException {  ////*[@id="list_img"]
		
		JXDocument jxDocument = JXDocument.createByUrl("http://www.umei.cc/tags/diaodai.htm");
		List<Object> list = jxDocument.sel("//*[@class=\"TypeList\"]//img");
		
		//list.forEach(System.out::println);
		
		for (Object object : list) {  ///html/body/div[2]/div[7]/ul/li[1]
			String node = object.toString();
			String name = node.substring(node.indexOf("alt=\"") + 5, node.indexOf("\" src=\""));
			//System.out.println(name);
			
			String url = node.substring(node.indexOf("src=\"") + 5, node.indexOf("\">"));
			if (!url.contains("http")) {
				url = "http://www.umei.cc" + url;
			}
			//System.out.println(url);
			
			FileUtils.copyURLToFile(new URL(url), new File("./img/"+name+".jpg"));
			System.out.println(name+"爬取完毕。");
			
		}
	}
}
