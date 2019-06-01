package cn.kgc.utlis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 打印指定月份的日期
 * 
 * @author zhuhao
 * @date 2019年3月26日
 */
public class PrintDate {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入指定格式的年月日（yyyy-MM-dd）：\n");
		String tmp = input.next();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(tmp);
		//设置时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		
		//获得这个月有多少天
		int actualMaximum = calendar.getActualMaximum(Calendar.DATE);
//		System.out.println("这个月有： " + actualMaximum + " 天");
		
		//获得指定日期
		int curdate = calendar.get(Calendar.DAY_OF_MONTH);
//		System.out.println("这个月是 ：" + curdate + " 号");
		
		//获得指定月份1号对应的星期
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int i1 = calendar.get(Calendar.DAY_OF_WEEK) - 1;
//		System.out.println("这个月的1号对应的星期是： " + i1);
		
		System.out.println("\n周日\t周一\t周二\t周三\t周四\t周五\t周六\n");
		for(int i=1; i<=actualMaximum; i++) {
			if(i == 1) {
				for (int j = 0; j < i1; j++) {
					System.out.print("\t");
				}
			}
			if(curdate == i) {
				System.out.print("*" + i + "*\t");
			}else {
				System.out.print(i + "\t");
			}
			if((i1 + i)%7 == 0 ) { 
				System.out.println("\n");
			}
		}
		
	}
	
}
