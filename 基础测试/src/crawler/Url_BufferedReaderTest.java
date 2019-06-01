package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Url_BufferedReaderTest {
	
	public static void main(String[] args) throws IOException {  //MalformedURLException:URL语法错误异常，Malformed：难看的，畸形的		
		
		URL url = new URL("http://www.baidu.com");
		
//		第一种方法
//		URLConnection urlcon = url.openConnection();
//		InputStream is = urlcon.getInputStream();
//		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		
//		第二种方法
//		HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
//		
//		InputStream is = urlcon.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader buffer = new BufferedReader(isr);
//		
//		BufferedReader buffer = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));  等价于上面三行
		
		
//		第三种方法
//		InputStream is = url.openStream();
//		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		BufferedReader buffer =new BufferedReader(new InputStreamReader(url.openStream()));  // 等价于上面两行
		
		StringBuffer sb = new StringBuffer();
		String l = null;
		while((l=buffer.readLine()) != null) {
			sb.append(l).append("\r\n");
		}
		
		System.out.println(sb.toString());
	}

}
