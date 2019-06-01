package com.zhuhao.imgcrawler;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 爬取某校花网站
 * 
 * @author zhuhao
 * @date 2019年3月28日
 */
public class ReptileMain3Thread {

	//	static String url = "http://www.xiaohuar.com/list-1-13.html";

	static String imgUrlRegex = "<img.*[^>]*?>";
	static String imgSrcRegex = "(?<=src=\\\")[-A-Za-z0-9+&@#/%?=~_|!:,.;]+(?=\\\")";
	static String imgNameRegex = "(?<=alt=\\\")[\\u4e00-\\u9fa5]*(?=\\\")";
	static String filePath = "H:\\爬取图片测试\\test\\";

	public static void test() {
		for (int i = 1; i <= 43; i++) {

			String url = "http://www.xiaohuar.com/list-1-" + i + ".html";
			ExecutorService pool = Executors.newCachedThreadPool();
			pool.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "\t");
					long begin = System.currentTimeMillis();
					String html = ReptileImg.getHtml(url);
					List<String> imgUrl = ReptileImg.getImgUrl(html, imgUrlRegex);
					List<String> imgSrc = ReptileImg.getImgSrc(imgUrl, imgSrcRegex);
					List<String> imgNameSrc = ReptileImg.getimgNameSrc(imgUrl, imgNameRegex);
					ReptileImg.download(imgSrc, imgNameSrc, filePath);
					
					long end = System.currentTimeMillis();
//					System.out.println("第 " + i + " 页耗时： " + (end - begin) + " 毫秒");
					
				}
			});
			
		}
	}



	public static void main(String[] args) {

		test();



	}

}
