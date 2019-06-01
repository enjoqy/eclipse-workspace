package crawler;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_获取url的基本信息 {
	
	public static void main(String[] args) throws MalformedURLException {
	
		URL url = new URL("https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9262879107065446608%22%7D&n_type=0&p_from=1");
		
		System.out.println("url： " + url.toString());
		System.out.println("验证信息： " + url.getAuthority());  //Authority: 权威，权利
		System.out.println("协议： " + url.getProtocol());  //protocol: 协议
		System.out.println("主机： " + url.getHost());
		System.out.println("端口： " + url.getPort());
		System.out.println("默认端口： " + url.getDefaultPort());
		System.out.println("资源路径：" + url.getFile());
		System.out.println("请求参数： " + url.getQuery());  //query:询问
		System.out.println("定位位置： " + url.getRef());
	}

}
