package cn.kgc.mydate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

/**
 * LocalDateTime\LocalDate\LocalTime： 1.JDK1.8+新特性
 * 2.之前的日期类都在java.util包下，新的日期类都在java.time 3.起源于一个组件joda-time
 * 4.是一个工具类，构造方法私有，不能直接创建对象。 5.常用方法： 1.now()：获取当前时间2019-03-26T13:44:58.156
 * T代表后面跟着时间 2.of(2019, 5, 1, 13, 12) 3.parse(dateString)
 * 4.getYear()\getMonth()\getMonthValue()\getDayOfMonth()\getDayOfWeek().getValue()
 * 6.LocalDateTime 和 Date之间的转换： 1.
 * 
 * DateTimeFormatter： 1.日期类格式化器 2.之前的DateFormat和SimpleDateFormat都在java.text包下
 * 3.DateTimeFormatter在java.time.format包下 3.常用方法；ofPattern("格式化模式")
 * 
 * Instant: 1.时间戳：实际上，这一瞬间存在一些限制。 可测量的时间线限制在long中可以持有的long 。 这大于当前估计的宇宙年龄。
 * 该瞬间存储为纳秒分辨率。 2.java.time包下
 * 
 * ZoneId 1.用于识别用于在Instant和LocalDateTime之间转换的规则。 2.常用方法：systemDefault()
 * 
 * @author junki
 * @date 2019年3月26日
 */

public class DemoLocalDateTime {

	@Test
	public void test1() {
		LocalDateTime localDateTime = LocalDateTime.now();

		// 獲取時間信息
		System.out.println(localDateTime);
		System.out.println(localDateTime.getDayOfMonth());
		System.out.println(localDateTime.getDayOfYear());
		System.out.println(localDateTime.getMonthValue());
		System.out.println(localDateTime.getYear());
		System.out.println(localDateTime.getMonth().getValue());
		System.out.println(localDateTime.getHour());
		System.out.println(localDateTime.getMinute());
		System.out.println(localDateTime.getDayOfWeek().getValue());
		System.out.println(localDateTime.getSecond());

		// 获取指定的时间
		LocalDateTime of = LocalDateTime.of(2010, 1, 14, 8, 56, 20, 1000);
		System.out.println(of);

		// 根据时间字符串获取
		String string = "2010-12-01T01:12:12.123"; // 默认格式
		LocalDateTime parse = LocalDateTime.parse(string);
		System.out.println(parse);

		String string2 = "年份: 2019 月份: 03 日期: 26 小时:13"; // 自定义格式
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("年份: yyyy 月份: MM 日期: dd 小时:HH");
		LocalDateTime parse2 = localDateTime.parse(string2, ofPattern);
		System.out.println(parse2);

		// 设置时间信息
		LocalDateTime withNano = localDateTime.withYear(2000).withMonth(12).withDayOfMonth(1).withHour(00)
				.withMinute(01).withSecond(59).withNano(8888);
		System.out.println(withNano);

		// 时间运算
		LocalDateTime plusSeconds = withNano.plusYears(19).plusMonths(-9).plusDays(25).plusHours(19).plusMinutes(17)
				.plusSeconds(1);
		System.out.println(plusSeconds);
		
		
		LocalDateTime l = localDateTime.now();
		String format = l.format(DateTimeFormatter.ofPattern("年份: yyyy 月份: MM 日期: dd 小时:HH"));
		System.out.println(format);
		
	}

	@Test
	public void test2() {

		// Date --> LocalDateTime 转化
		// 1，先转化成具有相同格式的字符串，在通过字符串解析出来
		Date date = new Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		String format = simpleDateFormat.format(date);
		LocalDateTime ld = LocalDateTime.parse(format, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println(ld);

		// 2，通过时间戳
		Date date2 = new Date();
		Instant instant = date2.toInstant();
		LocalDateTime ld1 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println(ld1);

	}

	@Test
	public void test3() throws ParseException {

		// LocalDateTime --> Date
		//1，先转化成具有相同格式的字符串，在通过字符串解析出来
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
		String format = now.format(ofPattern);
		System.out.println(format);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		Date date = simpleDateFormat.parse(format);
		System.out.println(date);
		
		// 2，通过时间戳
		LocalDateTime now2 = LocalDateTime.now();
		Instant instant = now2.atZone(ZoneId.systemDefault()).toInstant();
		Date date2 = new Date().from(instant);
		System.out.println(date2);
	}
	
	
	@Test
	public void test4() {
		//date --> LocalDateTime转化
		//1，利用相同格式的时间字符串
		Date date = new Date();
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date);
		LocalDateTime parse = LocalDateTime.parse(format, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println(parse);
		
		//2，利用时间戳
		Date date2 = new Date();
		Instant instant = date2.toInstant();
		LocalDateTime ofInstant = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println(ofInstant);
		
	}
	
	@Test
	public void test5() throws ParseException {
		
		//LocalDateTime --> Date
		//1，利用相同格式的时间字符串
		LocalDateTime now = LocalDateTime.now();
		String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
		Date date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse(format);
		System.out.println(date);
		
		//2,利用时间戳
		LocalDateTime now2 = LocalDateTime.now();
		Instant instant = now2.atZone(ZoneId.systemDefault()).toInstant();
		Date date2 = Date.from(instant);
		System.out.println(date2);
		
		LocalDateTime now3 = LocalDateTime.now();
		
//		Instant instant2 = now3.atOffset(ZoneOffset.of("+8")).toInstant();
//		Date from = Date.from(now3.toInstant(ZoneOffset.of("+8")));
		
		Instant instant3 = now3.toInstant(ZoneOffset.of("+8"));
		Date date3 = Date.from(instant3);
		System.out.println(date3);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
