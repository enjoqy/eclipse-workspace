package com.zhuhao.imgcrawler;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.seimicrawler.xpath.JXDocument;

public class JsoupXpathDemo01 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		test();
	}

	public static void test() throws MalformedURLException, IOException {
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 43; i++) {
			String url = "http://www.xiaohuar.com/list-1-" + i + ".html";
			pool.submit(new Runnable() {
				@Override
				public void run() {

					System.out.println(Thread.currentThread().getName() + "\t");
					JXDocument jxDocument = JXDocument.createByUrl(url);
					List<Object> sel = jxDocument.sel("//*[@class=\"TypeList\"]//img"); 

					// <img src="http://i1.whymtj.com/uploads/tu/201903/10412/csa1q9a9.jpg"
					for (Object object : sel) {

						String node = object.toString();
						System.out.println(node);
						String imgUrl = node.substring(node.indexOf("src=\"") + 5, node.indexOf("\" width"));
						String imgName = node.substring(node.lastIndexOf("/") + 1, node.indexOf("\" width"));

						try {
							FileUtils.copyURLToFile(new URL(imgUrl), new File("H:\\爬取图片测试\\test" + imgName));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("正在下载： " + imgName);

					}
					System.out.println("下载完毕");



				}
			});

		}
	}
	
	@Test
	public void test01() {
		
		for (int j = 0; j < 43; j++) {
			
			String url = "http://www.xiaohuar.com/list-1-" + j + ".html";
			JXDocument jxDocument = JXDocument.createByUrl(url);
			List<Object> sel = jxDocument.sel("//*[@id=\"list_img\"]");   ////*[@id="list_img"]/div/div[1]
			
			// <img src="http://i1.whymtj.com/uploads/tu/201903/10412/csa1q9a9.jpg"
			for (Object object : sel) {
				
				String node = object.toString();
				System.out.println(node);
				String imgUrl = node.substring(node.indexOf("src=\"") + 5, node.indexOf("\" width"));
				String imgName = node.substring(node.lastIndexOf("/") + 1, node.indexOf("\" width"));
				
				try {
					FileUtils.copyURLToFile(new URL(imgUrl), new File("H:\\爬取图片测试\\test" + imgName));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("正在下载： " + imgName);
				
			}
		}
		System.out.println("下载完毕");
	}

}