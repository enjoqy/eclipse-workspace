package cn.kgc.myio;

import java.io.FileOutputStream;

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
}
