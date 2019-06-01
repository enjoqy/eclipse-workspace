package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class B {
	public String getHtmlUrl(String url, String encoding) throws   IOException {
		URL uri = new URL(url);
		BufferedReader br = new BufferedReader(new InputStreamReader(uri.openStream(), encoding));

		StringBuffer buffer = new StringBuffer();
		String s = null;
		while((s = br.readLine()) != null) {
			buffer.append(s).append("\r\n");
		}
		br.close();
		return buffer.toString();
	}

	public static void main(String[] args) throws IOException {
		
		String url = "http://www.nigu3.com/Art/AtrNr/28267.html";
		String encoding = "UTF-8";
		
		B a = new B();
		String html = a.getHtmlUrl(url, encoding);
		Document documents = Jsoup.parse(html);
		
		System.out.println(html);

	}
}
