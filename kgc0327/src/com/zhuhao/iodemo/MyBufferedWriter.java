package com.zhuhao.iodemo;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 向文件中写入内容
 *
 * @author zhuhao
 * @date   2019年3月12日
 */
public class MyBufferedWriter {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("f://tmp//demo//demo.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("内容写入中。。。");
			bw.write("Hello!");
			bw.newLine();
			bw.write("傻屌的编码方式！");
			bw.flush();
			System.out.println("内容写入成功！");
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("文件不存在！");
		}
	}
}
