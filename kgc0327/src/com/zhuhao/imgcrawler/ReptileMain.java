package com.zhuhao.imgcrawler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

public class ReptileMain {
	
	static String url = "http://www.xiaohuar.com/hua/";
	static String imgUrlRegex = "<img.*[^>]*?>";
//	static String imgSrcRegex = "http://.*?\\.jpg";
	static String imgSrcRegex = "(?<=src=\\\")[-A-Za-z0-9+&@#/%?=~_|!:,.;]+(?=\\\")";
//	static String imgNameRegex = "alt=\\\"\\S*\\\"";
//	static String imgNameRegex = "[\\u4e00-\\u9fa5]*";
	static String imgNameRegex = "(?<=alt=\\\")[\\u4e00-\\u9fa5]*(?=\\\")";
	static String filePath = "H:\\爬取图片测试\\";
	
	
	public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException, IOException {
		
		long begin = System.currentTimeMillis();
		String html = ReptileImg.getHtml(url);
		List<String> imgUrl = ReptileImg.getImgUrl(html, imgUrlRegex);
		List<String> imgSrc = ReptileImg.getImgSrc(imgUrl, imgSrcRegex);
		List<String> imgNameSrc = ReptileImg.getimgNameSrc(imgUrl, imgNameRegex);
		
		ReptileImg.download(imgSrc, imgNameSrc, filePath);
		long end = System.currentTimeMillis();
		System.out.println("\n共耗时： " + (end - begin) + " 毫秒");
	}

}
