package cn.kgc.mymath;

import java.util.Scanner;

/**
 * 测试常用的提取和搜索字符串的方法 
 *
 * @author zhuhao
 * @date   2019年3月11日
 */
public class Verify {
	public static void main(String[] args) {
		boolean fileCorrect = false;
		boolean emailCorrect = false;
		System.out.println("欢迎进入作业提交系统");
		Scanner input = new Scanner(System.in);
		System.out.println("请输入Java文件名");
		String fileName = input.next();
		System.out.println("请输入你的邮箱");
		String email = input.next();
		//检查文件名是否是合法的
		int index = fileName.indexOf('.');
		if(index!=-1 && index!=0 &&fileName.substring(index+1, fileName.length()).equals("java")) {
			fileCorrect = true;
		}else {
			System.out.println("文件名无效");
		}
		//检查电子邮箱是否合法
		if(email.indexOf('@')!=-1 && email.indexOf('.')>email.indexOf('@')) {
			emailCorrect = true;
		}else {
			System.out.println("E-mail无效");
		}
		//输出结果检测
		if(fileCorrect && emailCorrect) {
			System.out.println("作业提交成功");
		}else {
			System.out.println("作业提交失败");
		}
	}
}
