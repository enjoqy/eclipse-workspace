package com.zhuhao.imgcrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 通过HTML解析实现图片批量下载
 * 
 * @author zhuhao
 * @date 2019年3月29日
 */
public class HtmlHJsoup2 {

	/**
	 * 第一步：获取页面的源代码；
	 *  第二步：解析源代码，含有图片的标签，再找到图片标签里面的src；
	 *  第三步：利用Java里面的net包，网络编程
	 */

	// 下载的图片计数
	static int j = 0;

	public static String getHtmlResourceByUrl(String url, String encoding) throws IOException {

		URL urlObj = new URL(url);
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlObj.openStream(), encoding));

		StringBuffer buffer = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			buffer.append(line + "\r\n");
		}
		reader.close();
		return buffer.toString();
	}

	// 根据图片的URL下载的图片到本地的filePath
	public static void downImages(String filePath, String imageUrl) {
		// 截取图片的名称
		String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));

		// 创建文件的目录结构
		File files = new File(filePath);
		if (!files.exists()) {// 判断文件夹是否存在，如果不存在就创建一个文件夹
			files.mkdirs();
		}
		try {
			URL url = new URL(imageUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream is = connection.getInputStream();
			// 创建文件
			File file = new File(filePath + fileName);
			FileOutputStream out = new FileOutputStream(file);
			int i = 0;
			while ((i = is.read()) != -1) {
				out.write(i);
			}
			j++;
			is.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 执行测试程序代码
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		System.out.print("请输入网页地址：");
		String url = input.nextLine();

		String encoding = "gbk";
		String filePath = "H:\\爬取图片测试\\test";
		String htmlResource = getHtmlResourceByUrl(url, encoding);

		// 解析网页源代码
		Document document = Jsoup.parse(htmlResource);
		// 获取所有图片的地址
		Elements elements = document.getElementsByTag("img");

		for (Element element : elements) {
			String imgSrc = element.attr("src");
			if (!"".equals(imgSrc) && (imgSrc.startsWith("http://") || imgSrc.startsWith("https://"))) {
				// 判断imgSrc是否为空且是否以"http://"开头
				System.out.println("正在下载的图片的地址：" + imgSrc);
				downImages(filePath, imgSrc);
			}
		}

		System.out.println("总计下载了：  " + j + "  张图片");
		System.out.println("-------------------------下载完毕！----------------------------");
	}

}
