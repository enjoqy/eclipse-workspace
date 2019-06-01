package crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetPicture {

	private static final String URL_STR = "https://www.169tp.com/xingganmeinv/2017/0821/39484.html";  //https://www.169tp.com/xingganmeinv/2017/0821/39484.html
	private static final String IMGURL_REG = "<img.*[^>]*?>";
	private static final String IMGSRC_REG = "http://.*?\\.jpg";
	private static final String FILE = "F:\\test\\";
    
	
	public static void main(String[] args) throws IOException {

		GetPicture gp = new GetPicture();
		
		String html = gp.getHtml(URL_STR);
		List<String> imgUrl = gp.getImgUrl(html);
		List<String> imgSrc = gp.getImgSrc(imgUrl);
		gp.download(imgSrc, FILE);

	}


	//获取html网页源码
	private static String getHtml(String url_Html) throws IOException {
		URL url = new URL(url_Html);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
		String l = null;
		StringBuffer sb = new StringBuffer();
		while((l=buffer.readLine()) != null) {
			sb.append(l).append("\r\n");
		}
		return sb.toString();
	}

	//提取ImgURL
	private static List<String> getImgUrl(String html){
		List<String> listImgUrl = new ArrayList<String>();
		Matcher matcher = Pattern.compile(IMGURL_REG).matcher(html);
		while(matcher.find()) {
			listImgUrl.add(matcher.group());
		}
		return listImgUrl;
	}

	//提取ImgSrc
	private static List<String> getImgSrc(List<String> imgUrl){
		List<String> listImgSrc = new ArrayList<String>();
		for(String s : imgUrl) {
			Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(s);
			while(matcher.find()) {
				listImgSrc.add(matcher.group());
			}
		}
		return listImgSrc;
	}
	
	//下载图片
	private void download(List<String> listImgSrc, String file) throws IOException {
		int i = 0;
		Date beginDate = new Date();
		for(String url : listImgSrc) {
			Date beginDate2 = new Date();
			String imgName = url.substring(url.lastIndexOf("/")+1 , url.length());
			URL uri = new URL(url);
			
			InputStream is = uri.openStream();
			FileOutputStream fo = new FileOutputStream(new File(file , imgName));
			byte[] by = new byte[1024];
			int l = 0;
			System.out.println("开始下载： " + url);
			while((l = is.read(by, 0, by.length)) != -1) {
				fo.write(by, 0, by.length);
			}
			is.close();
			fo.close();
			System.out.println("下载完成！");
			i++;
			Date overDate2 = new Date();
			double time = overDate2.getTime() - beginDate2.getTime();
			System.out.println("耗时： " + time + "  毫秒");
		}
		Date overDate = new Date();
		double time = overDate.getTime() - beginDate.getTime();
		System.out.println("总计下载了 ： " + i + "  张图片");
		System.out.println("总耗时： " + time + "  毫秒");
	}


}
