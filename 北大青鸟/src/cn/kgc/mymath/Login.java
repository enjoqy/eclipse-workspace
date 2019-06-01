package cn.kgc.mymath;

import java.util.Scanner;

/**
 * == 用于比较两个对象在内存中的地址是否相等
 * equals 用于比较两个对象的值或者内容是否相等，是区分大小写的
 * equalsIgnoreCase（）忽略英文的大小写进行比较内容
 * 
 *
 * @author zhuhao
 * @date   2019年3月11日
 */
public class Login {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名！");
		String name = input.next();
		System.out.println("请输入密码！");
		String pwd = input.next();
		if(name.equals("zhuhao") && pwd.equals("102012")) {
			System.out.println("登录成功！");
		}else {
			System.out.println("用户名或者密码匹配不正确，登录失败！");
		}
		
		//equalsIgnoreCase（）忽略英文的大小写进行比较内容
		input = new Scanner(System.in);
		System.out.println("请输入用户名！");
		String name1 = input.next();
		System.out.println("请输入密码！");
		String pwd1 = input.next();
		if(name1.equalsIgnoreCase("zhuhao") && pwd1.equals("102012")) {
			System.out.println("登录成功！");
		}else {
			System.out.println("用户名或者密码匹配不正确，登录失败！");
		}
	}

}
