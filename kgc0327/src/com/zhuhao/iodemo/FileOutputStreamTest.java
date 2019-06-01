package com.zhuhao.iodemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

/**
 * 向文本文件中写入数据
 *
 * @author zhuhao
 * @date   2019年3月11日
 */
public class FileOutputStreamTest {
	public static void main(String[] args) {
		try {
			String str = "好好学习Java！";
			byte[] words = str.getBytes();
			FileOutputStream fos = new FileOutputStream("f://tmp\\demo\\hello.txt",true);
			fos.write(words, 0, words.length);
			System.out.println("文件已更新");
			fos.close();
		} catch (Exception e) {
			System.out.println("创建文件时出错！");
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() throws IOException {
		
		//输出的文件没有办法指定编码，是eclipse的编码
		String str = "你好啊！龙毛坯";
		byte[] tmp = str.getBytes();
		FileOutputStream fileOutputStream = new FileOutputStream(new File("H:\\JavaTmpFile\\test.txt"), true);
		fileOutputStream.write(tmp, 0, tmp.length);
		System.out.println("文件输出成功");
		fileOutputStream.close();
		
		FileInputStream fileInputStream = new FileInputStream(new File("H:\\\\JavaTmpFile\\\\test.txt"));
		byte[] tmp1 = new byte[1024];
		int len = 0;
		while((len = fileInputStream.read(tmp1)) != -1) {
			
			System.out.println(new String(tmp1, 0, len, "utf-8"));  //可以指定编码
		}
		fileInputStream.close();
	}
	
}
