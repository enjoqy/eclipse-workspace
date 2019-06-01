package com.zhuhao.imgcrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试爬虫
 * 
 * @author zhuhao
 * @date 2019年3月28日
 */

public class ReptileImg {

	// 首先获取html的源码
	public static String getHtml(String url) {
		
		StringBuffer sb = null;
		
		try {

			System.out.println("\n获取html源码。。。\n");

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "gbk"));
			sb = new StringBuffer();
			String tmp = null;

			while ((tmp = bufferedReader.readLine()) != null) {
				sb.append(tmp).append("\n");
			}
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println("有异常" + e.getMessage());
		}
		
		return sb.toString();
	}
	
	
	

	// 获取html中的imgurl
	public static List<String> getImgUrl(String html, String imgUrlRegex) {

		Matcher matcher = Pattern.compile(imgUrlRegex).matcher(html);
		List<String> listImgUrl = new ArrayList<>();
		while (matcher.find()) {
			String group = matcher.group();
			listImgUrl.add(group);
		}

//		System.out.println(listImgUrl + "\t");
		return listImgUrl;
	}

	
	
	
	
	
	// 获取imgurl中的图片地址
	public static List<String> getImgSrc(List<String> listImgUrl, String imgSrcRegex) {

		System.out.println("\n获取图片链接。。。\n");

		ArrayList<String> listImgSrc = new ArrayList<>();

		for (String string : listImgUrl) {
			
//			System.out.println(string);
			
			// 匹配Src后面的图片链接
			Matcher matcher = Pattern.compile(imgSrcRegex).matcher(string);
			while (matcher.find()) {
				String group = matcher.group();
//				System.out.println(group);
				//判断是否是http开头的，否则拼接
				if(group.substring(0, 3).equals("htt")) {
					listImgSrc.add(group);
//					System.out.println(group);
				}else {
					listImgSrc.add("http://www.xiaohuar.com" + group);
				}
				
			}
		}
		System.out.println(listImgSrc.size());
//		System.out.println(listImgSrc);
		return listImgSrc;
	}
	
	

	// 获取imgurl中的图片名字
	public static List<String> getimgNameSrc(List<String> listImgUrl, String imgNameRegex) {

		ArrayList<String> listNameSrc = new ArrayList<>();

		for (String string : listImgUrl) {

			// 匹配Src后面的图片名字
			Matcher matcher = Pattern.compile(imgNameRegex).matcher(string);
			while (matcher.find()) {
				String group = matcher.group();
				listNameSrc.add(group);
			}
		}
		System.out.println(listNameSrc.size());
		return listNameSrc;
	}
	

	// 下载图片
	public static void download(List<String> listImgSrc, List<String> listNameSrc, String filepPath){

		try {
			System.out.println("\n下载图片中。。。\n");

			FileOutputStream fileOutputStream = null;
			InputStream is = null;
			int acount = 1; // 计数
			
			for (String list : listImgSrc) {

				URL url2 = new URL(list);
				is = url2.openStream();

				System.out.print("正在下载第：\t" + acount + "\t张图片\t");
				if(listNameSrc.size() > acount+1 ) {
					fileOutputStream = new FileOutputStream(new File(filepPath + listNameSrc.get(acount)) + ".jpg");
					System.out.println(filepPath + listNameSrc.get(acount) + ".jpg");
				}else {
					fileOutputStream = new FileOutputStream(new File(filepPath + acount + ".jpg") );
					System.out.println(filepPath + acount + ".jpg");
				}
				
				acount++;

				byte[] tmp = new byte[1024];
				int len = 0;
				while ((len = is.read(tmp)) != -1) {
					fileOutputStream.write(tmp, 0, len);
				}
			}

			System.out.println("\n输出成功，共爬到： " + acount + " 张图片\n");

			is.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.out.println("有异常 " + e.getMessage());
		}

	}

}
