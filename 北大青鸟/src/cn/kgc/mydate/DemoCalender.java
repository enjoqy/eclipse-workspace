package cn.kgc.mydate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *  Calendar:
 * 		1.抽象类：有实现类GregorianCalendar。
 * 		2.通过Calendar.getInstance()获取单例对象。
 * 		3.提供了很多关于日期元素的常量。
 * 			1.YEAR	年
 * 			2.MONTH	月
 * 			3.DATE	日
 * 			4.DAY_OF_WEEK	星期
 * 		4.常用方法：
 * 			1.get(元素常量)\set(元素常量,设置值)	
 * 			2.getTime() 返回Date对象
 * 
 * 
 * DateFormat:
 * 		1.抽象类：获取对象使用getInstance()\getDateInstance()\getTimeInstance()\getDateTimeInstance()
 * 		2.常用方法：
 * 			1.format(date) 格式化日期对象 Date -> String
 * 			2.parse(string) 将格式化的日期字符串转为日期对象 String -> Date
 * 		3.注意事项：
 * 			想要格式化成不同的字符串，需要用不同的方法获取实例。
 * 			目前有四种获取单例的方法。
 * 
 * 
 * @author zhuhao
 * @date 2019年3月26日
 */
public class DemoCalender {

	public static void main(String[] args) {
		
		//1获得明天的日期
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		System.out.println(calendar.getTime());

		//2
		Date date2 = new Date((new Date().getTime() + (24*60*60*1000)));
		System.out.println(date2);

		//3
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.DATE, calendar2.get(Calendar.DATE) + 1);
		System.out.println(calendar2.getTime());
		
		
		
		
		//DataFormat四种获得实例并格式化的方式
		DateFormat df1 = DateFormat.getInstance();
		System.out.println(df1.format(new Date()));
		
		DateFormat df2 = DateFormat.getDateInstance();
		System.out.println(df2.format(new Date()));
		
		DateFormat df3 = DateFormat.getTimeInstance();
		System.out.println(df3.format(new Date()));

		DateFormat df4 = DateFormat.getDateTimeInstance();
		System.out.println(df4.format(new Date()));
		
		//SimpleDateFormat实例化的方式
		SimpleDateFormat df = new  SimpleDateFormat();
		
		SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss:SSS");
		System.out.println(s.format(new Date()));
		
		s = new SimpleDateFormat("SSS");
		System.out.println(s.format(new Date()));
		
		s = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(s.format(new Date()));
		
		s = new SimpleDateFormat("MM-dd HH:mm");
		System.out.println(s.format(new Date()));
		
		s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		System.out.println(s.format(new Date()));
		
		//SimpleDateFormat-->未格式化
		String dateString = "2019-3-26 11:30:35:111";
		try {
			Date parse = s.parse(dateString);
			System.out.println(parse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

