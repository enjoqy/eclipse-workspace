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

		//此处可修改图片存放位置，默认为d盘下的pictures文件夹
		File dir = new File( "f:\\mmonly.cc\\" );  //路径
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

		int[] pages = {169, 53, 23, 51, 33, 59, 80, 28, 90, 30};  //pages:页面
		String url_str = "http://www.mmonly.cc/mmtp/";  
		String[] indexname = {"xgmn", "swmn", "hgmn", "wgmv", "bjnmn", "nymn",
				"qcmn", "ctmn", "mnmx", "jpmn",};
		int no;
		String[] regex = {
				"http://www\\.mmonly\\.cc/mmtp/[a-zA-Z]+/\\d+\\.html\"><img",       // http://www.mmonly.cc/mmtp/xgmn/127944_9.html
				"http://www\\.mmonly\\.cc/mmtp/[a-z]+/\\d+"};
		String title_regex = "alt=\"[\\u4E00-\\u9FA5\\w\\s\\-]+\"\\ssrc=\"";
		String[] picture_regex = {
				"src=\"http://t1\\.hxzdhn\\.cc/uploads/.+\\.jpg\" /></a></p>",    //http://t1.hxzdhn.com/uploads/tu/bj/20160229/5sdxpdzvy2s.jpg    下载图片的网址规律
				"http://t1\\.hxzdhn\\.cc/uploads/.+\\.jpg"};                      //http://t1.hxzdhn.com/uploads/tu/bj/20160229/chuv5q5fjsg.jpg  
		//"src=\"http://t1\\.mmonly\\.cc/uploads/.+\\.jpg\" /></a></p>"          //http://t1.hxzdhn.com/uploads/tu/201611/tt/4cix0jkovyf.jpg
		//"http://t1\\.mmonly\\.cc/uploads/.+\\.jpg"   被替换的源码
		
		
		for( int i = 0; i < indexname.length; i++ )	{
			String index = indexname[i];
			String url = url_str + index + "/";     //第一次遍历输出的 url为：http://www.mmonly.cc/mmtp/xgmn/
			no = 10 + i;
			File dir_file = new File( dir, index );  //f:\\mmonly.cc\\xgmn  输出的文件路径
			int page = pages[i];   //pages第一位是 169
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

class Task implements Runnable {  //task:任务，，继承runnable实现多线程
	File dir;
	String url_str;
	int no, begin, end;
	String regex1;
	String regex2;
	String title_regex;
	String[] picture_regex = new String[2];

	public Task( File dir, String url_str, int no, String[] regex,	String title_regex, String[] picture_regex, int end )	{  //如果没有传入开始的值，默认从1开始，继续调用下面的方法
		this( dir, url_str, no, regex, title_regex, picture_regex, 1, end );
	}

	public Task( File dir, String url_str, int no, String[] regex, String title_regex, String[] picture_regex, int begin, int end )	{  //接收传入的一批参数
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

	@Override  //注释重写
	public void run() {
		WebsitList websitList = new WebsitList( url_str, no, begin, end, regex1, regex2, title_regex );  //websitlist: 网站列表
		try{
			websitList.initUrls();
		} catch( IOException e1 ) {
			System.out.println( url_str + "已跳过" );
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

			// 每下载完6个页面的图片休眠10秒，防止过于频繁访问断开连接
			if( i % 6 == 0 ) {
				System.out.println( "休息10秒" );
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
	
	// http://www.169bb.com/xingganmeinv/list_1_1.html   另外一个可供爬取的图片网站
	// ^[u4E00-u9FA5a-zA-Z]{2,}$
	
	private static String title_regex2 = "[\u4e00-\u9fa5\\w\\-]*[\u4e00-\u9fa5][\u4e00-\u9fa5\\w\\-]*";
	private static Pattern title_pattern2 = Pattern.compile( title_regex2 );

	private String pre_url;
	int begin, end;
	int num;
	Pattern pattern1, pattern2, title_pattern1;
	LinkedHashMap<String, String> urls = new LinkedHashMap<String, String>();

	public WebsitList( String url, int num, int begin, int end, String regex1, String regex2, String title_regex1 )	{  //WebSitList方法的左右就是接收一干参数
		// 当url="http://www.169bb.com/wangyouzipai/",num=2,total=351
		this.begin = begin;
		this.end = end;
		this.num = num;
		pre_url = url;  //... http://www.169bb.com/wangyouzipai/list_2_
		pattern1 = Pattern.compile( regex1 );  // == http://www\\.mmonly\\.cc/mmtp/[a-zA-Z]+/\\d+\\.html\"><img     //compile:编译；汇编
		pattern2 = Pattern.compile( regex2 );  // == http://www\\.mmonly\\.cc/mmtp/[a-z]+/\\d+
		title_pattern1 = Pattern.compile( title_regex1 );
	}

	public void initFirstUrls() throws IOException	{  //initFirstUrls:开始第一个url
		URL url = new URL( pre_url + "list_" + num + "_1.html" ); // http://www.mmonly.cc/mmtp/xgmn/list_10_1.html
		try	{
			BufferedReader in = new BufferedReader(	new InputStreamReader( url.openStream() ) );  //从url连接中获取到了网页源码存到了缓存中
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
				System.out.println( "已跳过" + url );
				continue;
			}
		}

	}

	private void matchAll( String line ) {  //用正则匹配
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
						System.out.println( "添加成功：" + title + url_str );
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
	String regex1;// 所要下载的文件资源的正则表达式
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
							// System.out.println( src_str + "添加成功" );
						}
					}
				}
			} catch( Exception e )
			{
				System.out.println( "已跳过" + url );
				continue;
			}
		}
	}

	public void downloadAll( File dir ) throws IOException {
		if( title == null )
			return;
		File dir2 = new File( dir, title );
		
		if( !dir2.exists() ) { //如果dir2文件夹不存在就创建
			dir2.mkdirs();
		}
		int num = 1;

		System.out.println( dir2 + ":创建成功" );

		Iterator<String> it = srcs.iterator();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(it.hasNext());
		while( it.hasNext() ) {
			try	{
				String src = (String)it.next();
				File file = new File( dir2, (num++) + ".jpg" );
				if( file.exists() )	{
					System.out.println( file + "已存在" );
					continue;
				}
				URL url = new URL( src );
				BufferedInputStream biStream = new BufferedInputStream(	url.openStream() );
				BufferedOutputStream boStream = new BufferedOutputStream(new FileOutputStream( file ) );

				System.out.println( title + ":" + src + "开始下载..." );

				byte[] buf = new byte[1024];
				int len;
				while( (len = biStream.read( buf )) != -1 )
				{
					boStream.write( buf, 0, len );
				}
				boStream.close();
				biStream.close();
				System.out.println( title + ":" + src + "下载完毕" );
			} catch( Exception e ) {
				System.out.println( "连接失败，跳过当前文件" );
				num--;
				continue;
			}
		}

	}
}
