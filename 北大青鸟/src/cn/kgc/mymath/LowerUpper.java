package cn.kgc.mymath;

/**
 * toLowerCase()转换字符串中的英文字符为小写
 * toUpperCase()转换字符串中的英文字符为大写
 * concat() concatenate 连接，用来连接连个字符串，等价于 "+"
 *
 * @author zhuhao
 * @date   2019年3月11日
 */
public class LowerUpper {
	
	public static void main(String[] args) {
		String demo = "这个是测试Demo!";
		String demo1 = demo.toLowerCase();
		System.out.println(demo1);
		String demo2 = demo.toUpperCase();
		System.out.println(demo2);
		
		String a = "111";
		String b = "222";
		String c = a+b;
		System.out.println(c);
		String c1 = a.concat(b);
		System.out.println(c1);
	}

}
