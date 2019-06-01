package cn.kgc.utlis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetHtml {
	
	private static final String URL = "https://image.baidu.com/search/index?tn=baiduimage&ct=201326592&lm=-1&cl=2&ie=gb18030&word=%D0%A3%BB%A8&fr=ala&ala=1&alatpl=adress&pos=0&hs=2&xthttps=111111";  //http://www.tooopen.com/view/1439719.html
	private static final String IMGURL_REG = "<img.*[^>]*?>";  //<img.*src=(.*?)[^>]*?>   //<img.*[^>]*?>
	private static final String IMGSRC_REG = "http://.*?\\.jpg";   //  <img\b.*?(?:\>|\/>)/gi    [a-zA-Z]+://[^\\s]*   http://.*?\\.jpg
	
	public static void main(String[] args) throws IOException { // src\b\s*=\s*[\'\"]?([^\'\"]*)[\'\"]?   [a-zA-z]+://[^\\s]*    src\\b\\s*=\\s*[\'\"]?([^\'\"]*)[\'\"]?
		
		GetHtml m = new GetHtml();
		
		//获取html文本内容
		String HTML =  m.getHtml(URL);
		//获取图片标签
		List<String> imgUrl = m.getImageUrl(HTML);
		//获取图片的src地址
		List<String> imgSrc = m.getImageSrc(imgUrl);
		System.out.println(imgSrc);
		
		//下载图片
		m.download(imgSrc);
		
	}
	
	//获取html内容
	private static String getHtml(String url) throws IOException {
		URL urll = new URL(url);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(urll.openStream(), "GBK"));
		
		StringBuffer sb = new StringBuffer();
		String str = null;
		while((str = buffer.readLine())!=null) {
			sb.append(str).append("\n");
		}
		buffer.close();
		return sb.toString();
	}
	
	//获取ImageUrl地址
	private List<String> getImageUrl(String html){
		
		Matcher matcher = Pattern.compile(IMGURL_REG).matcher(html);
		List<String> listImgUrl = new ArrayList<String>();
		
		while(matcher.find()) {
			listImgUrl.add(matcher.group());
		}
		
		return listImgUrl;
	}
	
	//获取ImageSrc地址
	private List<String> getImageSrc(List<String> listImageUrl){
		
		List<String> listImageSrc = new ArrayList<String>();
		
		for(String image : listImageUrl) {
			Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(image);
			while(matcher.find()) {
				listImageSrc.add(matcher.group().substring(0, matcher.group().length()));  //substring()方法 返回字符串的子字符串
			}
		}
		
		return listImageSrc;
	}
	
	
	private void download(List<String> listImgSrc) throws IOException {
		//开始时间
		Date beginDate = new Date();
		for(String url : listImgSrc) {
			//开始时间
			Date beginDate2 = new Date();
			String imageName = url.substring(url.lastIndexOf("/")+1, url.length());
			URL uri = new URL(url);
			InputStream in = uri.openStream();
			FileOutputStream fo = new FileOutputStream(new File("H:\\爬取图片测试\\" + imageName));
			byte[] buf = new byte[1024];
			int length=0;
			System.out.println("开始下载： " + url);
			while((length = in.read(buf, 0, buf.length)) != -1) {
				fo.write(buf, 0, buf.length);
			}
			in.close();
			fo.close();
			System.out.println(imageName + "下载完成！");
			//结束时间
			Date overDate2 = new Date();
			double time = overDate2.getTime() - beginDate2.getTime();
			System.out.println("耗时： " + time + " 毫秒");
		}
		Date overDate = new Date();
		double time = overDate.getTime() - beginDate.getTime();
		System.out.println("总耗时： " + time + " 毫秒");
		
	}

}
