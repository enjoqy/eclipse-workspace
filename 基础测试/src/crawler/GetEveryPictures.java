package crawler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetEveryPictures {

	public static void main( String[] args ) throws InterruptedException {

		//�˴����޸�ͼƬ���λ�ã�Ĭ��Ϊd���µ�pictures�ļ���
		File dir = new File( "f:\\mmonly.cc\\" );  //·��
		// http://www.mmonly.cc/mmtp/xgmn/ : 10 : 169
		// http://www.mmonly.cc/mmtp/swmn/ : 11 : 53
		// http://www.mmonly.cc/mmtp/hgmn/ : 12 : 23
		// http://www.mmonly.cc/mmtp/wgmv/ 51
		// http://www.mmonly.cc/mmtp/bjnmn/ 33
		// http://www.mmonly.cc/mmtp/nymn/ 59
		// http://www.mmonly.cc/mmtp/qcmn/ 80
		// http://www.mmonly.cc/mmtp/ctmn/ 28
		// http://www.mmonly.cc/mmtp/mnmx/ 90
		// http://www.mmonly.cc/mmtp/jpmn/ 30

		int[] pages = {169, 53, 23, 51, 33, 59, 80, 28, 90, 30};  //pages:ҳ��
		String url_str = "http://www.mmonly.cc/mmtp/";  
		String[] indexname = {"xgmn", "swmn", "hgmn", "wgmv", "bjnmn", "nymn",
				"qcmn", "ctmn", "mnmx", "jpmn",};
		int no;
		String[] regex = {
				"http://www\\.mmonly\\.cc/mmtp/[a-zA-Z]+/\\d+\\.html\"><img",       // http://www.mmonly.cc/mmtp/xgmn/127944_9.html
				"http://www\\.mmonly\\.cc/mmtp/[a-z]+/\\d+"};
		String title_regex = "alt=\"[\\u4E00-\\u9FA5\\w\\s\\-]+\"\\ssrc=\"";
		String[] picture_regex = {
				"src=\"http://t1\\.hxzdhn\\.cc/uploads/.+\\.jpg\" /></a></p>",    //http://t1.hxzdhn.com/uploads/tu/bj/20160229/5sdxpdzvy2s.jpg    ����ͼƬ����ַ����
				"http://t1\\.hxzdhn\\.cc/uploads/.+\\.jpg"};                      //http://t1.hxzdhn.com/uploads/tu/bj/20160229/chuv5q5fjsg.jpg  
		//"src=\"http://t1\\.mmonly\\.cc/uploads/.+\\.jpg\" /></a></p>"          //http://t1.hxzdhn.com/uploads/tu/201611/tt/4cix0jkovyf.jpg
		//"http://t1\\.mmonly\\.cc/uploads/.+\\.jpg"   ���滻��Դ��
		
		
		for( int i = 0; i < indexname.length; i++ )	{
			String index = indexname[i];
			String url = url_str + index + "/";     //��һ�α�������� urlΪ��http://www.mmonly.cc/mmtp/xgmn/
			no = 10 + i;
			File dir_file = new File( dir, index );  //f:\\mmonly.cc\\xgmn  ������ļ�·��
			int page = pages[i];   //pages��һλ�� 169
			for( int j = 1; j <= page; j++ ) {
				Task task = new Task( dir_file, url, no, regex, title_regex,picture_regex, j, j );
				new Thread( task ).start();
				if( j % 10 == 0 )
					Thread.sleep( 20000 );
			}
			// Thread.sleep( 60000 );
		}
	}
}

class Task implements Runnable {  //task:���񣬣��̳�runnableʵ�ֶ��߳�
	File dir;
	String url_str;
	int no, begin, end;
	String regex1;
	String regex2;
	String title_regex;
	String[] picture_regex = new String[2];

	public Task( File dir, String url_str, int no, String[] regex,	String title_regex, String[] picture_regex, int end )	{  //���û�д��뿪ʼ��ֵ��Ĭ�ϴ�1��ʼ��������������ķ���
		this( dir, url_str, no, regex, title_regex, picture_regex, 1, end );
	}

	public Task( File dir, String url_str, int no, String[] regex, String title_regex, String[] picture_regex, int begin, int end )	{  //���մ����һ������
		this.dir = dir;
		this.url_str = url_str;
		this.no = no;
		this.begin = begin;
		this.end = end;
		regex1 = regex[0];  // == http://www\\.mmonly\\.cc/mmtp/[a-zA-Z]+/\\d+\\.html\"><img
		regex2 = regex[1];  // == http://www\\.mmonly\\.cc/mmtp/[a-z]+/\\d+
		this.picture_regex[0] = picture_regex[0];  // == src=\"http://t1\\.hxzdhn\\.cc/uploads/.+\\.jpg\" /></a></p>
		this.picture_regex[1] = picture_regex[1];  // == http://t1\\.hxzdhn\\.cc/uploads/.+\\.jpg
		this.title_regex = title_regex;  // == alt=\"[\\u4E00-\\u9FA5\\w\\s\\-]+\"\\ssrc=\"
	}

	@Override  //ע����д
	public void run() {
		WebsitList websitList = new WebsitList( url_str, no, begin, end, regex1, regex2, title_regex );  //websitlist: ��վ�б�
		try{
			websitList.initUrls();
		} catch( IOException e1 ) {
			System.out.println( url_str + "������" );
		}
		Iterator<String> iterator = websitList.urls.keySet().iterator();
		int i = 0;
		while( iterator.hasNext() )		{
			i++;
			try	{
				String main = iterator.next();
				String title = websitList.urls.get( main );
				System.out.println( main + ":" + title );

				DetailPage detailPage = new DetailPage( main, title,
						picture_regex );
				detailPage.initSrcs();
				detailPage.downloadAll( dir );
			} catch( Exception e )
			{
				continue;
			}

			// ÿ������6��ҳ���ͼƬ����10�룬��ֹ����Ƶ�����ʶϿ�����
			if( i % 6 == 0 ) {
				System.out.println( "��Ϣ10��" );
				for( int j = 0; j < 10; j++ ) {
					try {
						Thread.sleep( 1000 );
					} catch( InterruptedException e ) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}
		}
	}
}

/**
 * @classname WebsitList
 * @author LiShengc
 */


class WebsitList {
	
	// http://www.169bb.com/xingganmeinv/list_1_1.html   ����һ���ɹ���ȡ��ͼƬ��վ
	// ^[u4E00-u9FA5a-zA-Z]{2,}$
	
	private static String title_regex2 = "[\u4e00-\u9fa5\\w\\-]*[\u4e00-\u9fa5][\u4e00-\u9fa5\\w\\-]*";
	private static Pattern title_pattern2 = Pattern.compile( title_regex2 );

	private String pre_url;
	int begin, end;
	int num;
	Pattern pattern1, pattern2, title_pattern1;
	LinkedHashMap<String, String> urls = new LinkedHashMap<String, String>();

	public WebsitList( String url, int num, int begin, int end, String regex1, String regex2, String title_regex1 )	{  //WebSitList���������Ҿ��ǽ���һ�ɲ���
		// ��url="http://www.169bb.com/wangyouzipai/",num=2,total=351
		this.begin = begin;
		this.end = end;
		this.num = num;
		pre_url = url;  //... http://www.169bb.com/wangyouzipai/list_2_
		pattern1 = Pattern.compile( regex1 );  // == http://www\\.mmonly\\.cc/mmtp/[a-zA-Z]+/\\d+\\.html\"><img     //compile:���룻���
		pattern2 = Pattern.compile( regex2 );  // == http://www\\.mmonly\\.cc/mmtp/[a-z]+/\\d+
		title_pattern1 = Pattern.compile( title_regex1 );
	}

	public void initFirstUrls() throws IOException	{  //initFirstUrls:��ʼ��һ��url
		URL url = new URL( pre_url + "list_" + num + "_1.html" ); // http://www.mmonly.cc/mmtp/xgmn/list_10_1.html
		try	{
			BufferedReader in = new BufferedReader(	new InputStreamReader( url.openStream() ) );  //��url�����л�ȡ������ҳԴ��浽�˻�����
			String line;
			while( (line = in.readLine()) != null )	{
				matchAll( line );
			} 
		} catch( Exception e ) {
			return;
		}
	}

	public void initUrls() throws IOException {
		
		// initFirstUrls();
		URL url = null;
		for( int i = begin; i <= end; i++ )	{
			try	{
				if( i != 1 )
					url = new URL(
							pre_url + "list_" + num + "_" + i + ".html" );
				else {
					url = new URL( pre_url );
				}
				BufferedReader in = new BufferedReader(	new InputStreamReader( url.openStream() ) );
				String line;
				while( (line = in.readLine()) != null )	{
					matchAll( line );
				}
			} catch( Exception e )	{
				System.out.println( "������" + url );
				continue;
			}
		}

	}

	private void matchAll( String line ) {  //������ƥ��
		String url_str, title;
		Matcher matcher1 = pattern1.matcher( line );
		Matcher title_matcher1 = title_pattern1.matcher( line );
		String match, title_match;
		while( matcher1.find() ) {
			match = matcher1.group();
			Matcher matcher2 = pattern2.matcher( match );
			if( matcher2.find() ) {
				if( title_matcher1.find() ) {
					title_match = title_matcher1.group();
					Matcher title_matcher2 = title_pattern2.matcher( title_match );
					if( title_matcher2.find() )	{
						url_str = matcher2.group();
						title = title_matcher2.group();
						urls.put( url_str, title );
						System.out.println( "��ӳɹ���" + title + url_str );
					}
				}
			}
		}
	}

	public int getTotal()	{
		return end;
	}

	public void setTotal( int total )	{
		this.end = total;
	}

}

class DetailPage {
	private static String page_regex = "\\u5171(\\d+)+\\u9875";
	private static Pattern page_pattern = Pattern
			.compile( "\\u5171(\\d+)+\\u9875" );

	String title;
	private int pages = 1;
	LinkedList<String> srcs = new LinkedList<String>();
	String pre_main;
	String regex1;// ��Ҫ���ص��ļ���Դ��������ʽ
	String regex2;
	Pattern pattern1, pattern2;

	public DetailPage( String main, String title, String[] regex )
			throws IOException
	{
		this.title = title;
		this.pre_main = main;
		this.regex1 = regex[0];
		this.regex2 = regex[1];
		pattern1 = Pattern.compile( regex1 );
		pattern2 = Pattern.compile( regex2 );
		initPages();
	}

	private void initPages() throws IOException
	{
		try
		{
			URL url = new URL( pre_main + ".html" );
			BufferedReader in = new BufferedReader(
					new InputStreamReader( url.openStream() ) );
			String line;
			while( (line = in.readLine()) != null )
			{
				Matcher matcher = page_pattern.matcher( line );
				if( matcher.find() )
				{
					pages = Integer.parseInt(
							matcher.group().replaceAll( page_regex, "$1" ) );
					return;
				}
			}
		} catch( Exception e )
		{
			pages = 0;
			return;
		}
	}

	public void initSrcs() throws IOException
	{
		URL url = null;
		for( int i = 1; i <= pages; i++ )
		{
			try
			{
				String url_str = pre_main;
				if( i != 1 )
				{
					url_str = url_str + "_" + i;
				}
				url = new URL( url_str + ".html" );
				BufferedReader in = new BufferedReader(
						new InputStreamReader( url.openStream() ) );
				String line;
				while( (line = in.readLine()) != null )
				{
					Matcher matcher = pattern1.matcher( line );
					if( matcher.find() )
					{
						Matcher matcher2 = pattern2.matcher( matcher.group() );
						if( matcher2.find() )
						{
							String src_str = matcher2.group();
							srcs.add( src_str );
							// System.out.println( src_str + "��ӳɹ�" );
						}
					}
				}
			} catch( Exception e )
			{
				System.out.println( "������" + url );
				continue;
			}
		}
	}

	public void downloadAll( File dir ) throws IOException {
		if( title == null )
			return;
		File dir2 = new File( dir, title );
		
		if( !dir2.exists() ) { //���dir2�ļ��в����ھʹ���
			dir2.mkdirs();
		}
		int num = 1;

		System.out.println( dir2 + ":�����ɹ�" );

		Iterator<String> it = srcs.iterator();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(it.hasNext());
		while( it.hasNext() ) {
			try	{
				String src = (String)it.next();
				File file = new File( dir2, (num++) + ".jpg" );
				if( file.exists() )	{
					System.out.println( file + "�Ѵ���" );
					continue;
				}
				URL url = new URL( src );
				BufferedInputStream biStream = new BufferedInputStream(	url.openStream() );
				BufferedOutputStream boStream = new BufferedOutputStream(new FileOutputStream( file ) );

				System.out.println( title + ":" + src + "��ʼ����..." );

				byte[] buf = new byte[1024];
				int len;
				while( (len = biStream.read( buf )) != -1 )
				{
					boStream.write( buf, 0, len );
				}
				boStream.close();
				biStream.close();
				System.out.println( title + ":" + src + "�������" );
			} catch( Exception e ) {
				System.out.println( "����ʧ�ܣ�������ǰ�ļ�" );
				num--;
				continue;
			}
		}

	}
}
