package cn.kgc.mymath;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DemoAppend {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("青春无悔");
		sb.append("，是真的！");
		sb.append(110);
		sb.append('H');
		System.out.println(sb);
		StringBuffer a = new StringBuffer("18355182591");
		System.out.println(a);
		//从后往前每隔4位插入空格
		for(int i=a.length(); i>0; i=i-4) {
			a.insert(i, " ");
		}
		System.out.println(a);


		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat format = new SimpleDateFormat("中国北京时间 yyyy-MM-dd HH:mm:ss");
		System.out.println("格式化的日期： " + format.format(date));
		Calendar t = Calendar.getInstance();
		System.out.println("今天是：" + t.get(Calendar.YEAR) + "年" + (t.get(Calendar.MONTH)+1) + "月" + t.get(Calendar.DAY_OF_MONTH) + "日");
		System.out.println("今天是星期" + (t.get(Calendar.DAY_OF_WEEK)-1));

		Random rand = new Random(47);
		for(int i=0; i<20; i++) {
			int num = rand.nextInt(10);
			System.out.print(num + "\t");
		}
		System.out.println();
		
		Random rand1 = new Random(47);
		for(int i=0; i<20; i++) {
			int num = rand1.nextInt(10);
			System.out.print(num + "\t");
		}
		System.out.println();
	}
}
