package com.zhuhao.imgcrawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 测试jsoup架包的使用
 * 
 * @author zhuhao
 * @date 2019年3月29日
 */
public class JsopDemo {

	static String url = "http://www.xiaohuar.com/hua/";
	static String imgUrlRegex = "<img.*[^>]*?>";
	static String imgSrcRegex = "(?<=src=\\\")[-A-Za-z0-9+&@#/%?=~_|!:,.;]+(?=\\\")";
	static String imgNameRegex = "(?<=alt=\\\")[\\u4e00-\\u9fa5]*(?=\\\")";

	
	
	public static void main(String[] args) throws IOException {

		List<String> listImgUrl = new ArrayList<>();

		// 获取html源码
		Document doc = Jsoup.connect("http://www.xiaohuar.com/hua/").get();
		String html = doc.html();

		// 获取html中的imgurl
		Elements select2 = doc.select("img[src$=.jpg]");
		for (Element element : select2) {  ////
			listImgUrl.add(element.toString());
		}

		List<String> listImgSrc = JsopDemo.getImgSrc(listImgUrl, imgSrcRegex);
		List<String> listNameSrc = JsopDemo.getimgNameSrc(listImgUrl, imgNameRegex);
		JsopDemo.download(listImgSrc, listNameSrc, "H:\\爬取图片测试\\常居网\\");

//		//扩展名为.png的图片
//		Elements select = doc.select("img[src$=.jpg]");
//		for (Element element : select) {
//			System.out.println(element);
//		}

		// 获取文章标题
		String title = doc.title();
		System.out.println(title);
	}

	// 获取imgurl中的图片地址
	public static List<String> getImgSrc(List<String> listImgUrl, String imgSrcRegex) {

		System.out.println("\n获取图片链接。。。\n");

		ArrayList<String> listImgSrc = new ArrayList<>();

		for (String string : listImgUrl) {

//				System.out.println(string);

			// 匹配Src后面的图片链接
			Matcher matcher = Pattern.compile(imgSrcRegex).matcher(string);
			while (matcher.find()) {
				String group = matcher.group();
//					System.out.println(group);
				// 判断是否是http开头的，否则拼接
				if (group.substring(0, 3).equals("htt")) {
					listImgSrc.add(group);
//						System.out.println(group);
				} else {
					listImgSrc.add("http://www.xiaohuar.com" + group);
				}

			}
		}
		System.out.println(listImgSrc.size());
//			System.out.println(listImgSrc);
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
	public static void download(List<String> listImgSrc, List<String> listNameSrc, String filepPath) {

		try {
			System.out.println("\n下载图片中。。。\n");

			FileOutputStream fileOutputStream = null;
			InputStream is = null;
			int acount = 0; // 计数

			for (String list : listImgSrc) {

				URL url2 = new URL(list);
				is = url2.openStream();

				System.out.print("正在下载第：\t" + (acount+1) + "\t张图片\t");
				
				fileOutputStream = new FileOutputStream(new File(filepPath + listNameSrc.get(acount)) + ".jpg");
				System.out.println(filepPath + listNameSrc.get(acount) + ".jpg");

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
