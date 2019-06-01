package crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ͨ��HTML����ʵ��ͼƬ��������
 * @author DorraChen
 * @version v1.0
 * @date 2017��10��22�� ����11:36:55
 */

public class HtmlJsoup2 {
	/**
	 * ��һ������ȡҳ���Դ���룻
	 * �ڶ���������Դ���룬����ͼƬ�ı�ǩ�����ҵ�ͼƬ��ǩ�����src��
	 * ������������Java�����net����������
	 * */

	//���ص�ͼƬ����
	static int j = 0;
	
	
	public static String getHtmlResourceByUrl(String url,String encoding) throws IOException {
	
		URL urlObj = new URL(url);
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlObj.openStream(), encoding));

		StringBuffer buffer   = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			buffer.append(line+"\r\n");
		}
		reader.close();
		return buffer.toString();
	}

	//����ͼƬ��URL���ص�ͼƬ�����ص�filePath
	public static void downImages(String filePath,String imageUrl){
		// ��ȡͼƬ������
		String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));

		//�����ļ���Ŀ¼�ṹ
		File files = new File(filePath);
		if(!files.exists()){// �ж��ļ����Ƿ���ڣ���������ھʹ���һ���ļ���
			files.mkdirs();
		}
		try {
			URL url = new URL(imageUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream is = connection.getInputStream();
			// �����ļ�
			File file = new File(filePath+fileName);
			FileOutputStream out = new FileOutputStream(file);
			int i = 0;
			while((i = is.read()) != -1){
				out.write(i);
			}
			j++;
			is.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//ִ�в��Գ������
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		System.out.print("��������ҳ��ַ��");
		String url =  input.nextLine();
		
		String encoding =  "UTF-8"; 
		String filePath = "F://test//xingganmeinv" ;
		String htmlResource = getHtmlResourceByUrl(url, encoding);

		// ������ҳԴ����
		Document document = Jsoup.parse(htmlResource);
		// ��ȡ����ͼƬ�ĵ�ַ
		Elements elements = document.getElementsByTag("img");

		for(Element element : elements){
			String imgSrc = element.attr("src");
			if (!"".equals(imgSrc) && (imgSrc.startsWith("http://") || imgSrc.startsWith("https://"))) {
				// �ж�imgSrc�Ƿ�Ϊ�����Ƿ���"http://"��ͷ
				System.out.println("�������ص�ͼƬ�ĵ�ַ��" + imgSrc);
				downImages(filePath, imgSrc);
			}
		}

		System.out.println("�ܼ������ˣ�  " + j + "  ��ͼƬ");
		System.out.println("-------------------------������ϣ�----------------------------");
	}
}