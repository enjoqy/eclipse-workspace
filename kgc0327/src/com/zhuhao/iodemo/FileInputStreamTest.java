package com.zhuhao.iodemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * FileInputStream：
 * 		输入流：读操作，把系统文件读到java代码中
 * 
 * @author junki
 * @date 2019年3月27日
 */
public class FileInputStreamTest {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("H:\\JavaTmpFile\\test.txt");
		
		System.out.println("可读取的字节数：" + fis.available());
		System.out.println("文件内容为：");
		
		byte[] tmp = new byte[1024];
		int len = 0;
		while((len = fis.read(tmp)) != -1) {
			System.out.println(new String(tmp, 0, len, "gbk"));
		}
		
		fis.close();
	}
	
	@Test
	public void test1() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File("h:\\JavaTmpFile\\fg.png"));
		FileOutputStream fileOutputStream = new FileOutputStream(new File("h:\\JavaTmpFile\\fg11.jpg"));
		
		byte[] c = new byte[1024];
		
		while((fileInputStream.read(c)) != -1) {
			fileOutputStream.write(c);
		}
		
		System.out.println("文件拷贝成功");
		
		fileOutputStream.close();
		fileInputStream.close();
		
	}
}

