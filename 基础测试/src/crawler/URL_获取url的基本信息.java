package crawler;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_��ȡurl�Ļ�����Ϣ {
	
	public static void main(String[] args) throws MalformedURLException {
	
		URL url = new URL("https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9262879107065446608%22%7D&n_type=0&p_from=1");
		
		System.out.println("url�� " + url.toString());
		System.out.println("��֤��Ϣ�� " + url.getAuthority());  //Authority: Ȩ����Ȩ��
		System.out.println("Э�飺 " + url.getProtocol());  //protocol: Э��
		System.out.println("������ " + url.getHost());
		System.out.println("�˿ڣ� " + url.getPort());
		System.out.println("Ĭ�϶˿ڣ� " + url.getDefaultPort());
		System.out.println("��Դ·����" + url.getFile());
		System.out.println("��������� " + url.getQuery());  //query:ѯ��
		System.out.println("��λλ�ã� " + url.getRef());
	}

}
