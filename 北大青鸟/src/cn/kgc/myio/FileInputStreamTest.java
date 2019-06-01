package cn.kgc.myio;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取文本文件
 *
 * @author zhuhao
 * @date   2019年3月11日
 */
public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("f:\\tmp\\demo\\hello.txt");
		int data;
		System.out.println("可读取的字节数：" + fis.available());
		System.out.println("文件内容为：");
		while((data=fis.read())!=-1) {
			System.out.println(data + " ");
		}
		fis.close();
	}
}

