package com.zhuhao.iodemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * File类：
 * 		1.文件和目录路径名的抽象表示。
 * 		2.是io流的基础
 * 		3.常用方法：
 * 			1.有参构造new File(文件地址)：D:\\test.txt 或者 D:/test.txt
 * 			2.文件操作
 * 				exists()\createNewFile()\isFile()
 * 			3.文件夹操作
 * 				exists()\mkdir()\isDirectory()
 * 
 * 
 * @author junki
 * @date 2019年3月27日
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("H://test.txt");
		boolean createNewFile = file.createNewFile();
		System.out.println(createNewFile);

		boolean directory = file.isDirectory();
		System.out.println(directory);

		boolean exists = file.exists();
		System.out.println(exists);

		boolean file2 = file.isFile();
		System.out.println(file2);

	}

	@Test
	public void test01() throws IOException {
		InputStream in = new FileInputStream(new File("H://test.txt"));

		int tmp = 0;
		while ((tmp = in.read()) != -1) {
			System.out.print((char) tmp);
		}
		System.out.println("---");
		in.close();
	}

	@Test
	public void test2() throws IOException { // 中文乱码

		InputStream in = new FileInputStream(new File("H://test.txt"));

		byte[] tmp = new byte[1024];
		int len = 0;

		while ((len = in.read(tmp)) != -1) {
			System.out.println(new String(tmp,0,len, "gbk"));
		}
	}

	@Test
	public void test3() throws IOException {
		Reader frReader = new FileReader(new File("H://test.txt"));
		FileWriter fileWriter = new FileWriter("H://testcopy.txt");
		
		

		// byte[] tmp = new byte[1024];
		int c = 0;

		while ((c = frReader.read()) != -1) { // 此处中文乱码，因为本地文件和jvm使用的不是同一种编码，通过另一个节点流FileInputStream转码。
			fileWriter.write(c);
		}
		frReader.close();
		fileWriter.close();

	}

	@Test
	public void test4() throws FileNotFoundException {
		
	}

	@Test
	public void test5() throws IOException {
		
		//将乘法表写入文件，使用fileWriter写入
		
//		使用字符串接收
//		StringBuilder stringBuilder = new StringBuilder();
//		for (int i = 1; i <= 9; i++) {
//			for (int j = 1; j <= i; j++) {
//				stringBuilder.append(i + "*" + j + "=" + (i * j) + "\t");
//			}
//			stringBuilder.append("\n\n");
//		}
//		fileWriter.write(stringBuilder.toString());
		
		FileWriter fileWriter = new FileWriter(new File("demo01.txt"));
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				fileWriter.write("" + i + "*" + j + "=" + (i * j) + "\t");
			}
			fileWriter.write("\n\n");
		}
		
		fileWriter.close();
		
		
	}
	
	@Test
	public void test6() throws FileNotFoundException {
		
		//使用重定向io流，将控制台的输出，重定向到io流，并输出到文件
		
		PrintStream printStream = new PrintStream(new FileOutputStream(new File("demo02.txt")));
		System.setOut(printStream);
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + (i * j) + "\t");
			}
			System.out.println("\n");
		}
		
		printStream.close();
		
	}
	
	@Test
	public void test7() throws IOException {
		
		Reader frReader = new FileReader(new File("H://test.txt"));
		FileWriter fileWriter = new FileWriter("H://testcopy1111.txt");
		
		//使用架包复制文件
		IOUtils.copy(frReader, fileWriter);
		System.out.println("输出成功");
		
		IOUtils.closeQuietly(frReader);;
		IOUtils.closeQuietly(fileWriter);
		
	}
	
	@Test
	public void test8() throws IOException {
		
		//使用架包读取文件
		String readFileToString = FileUtils.readFileToString(new File("H://test.txt"), "gbk");
		System.out.println(readFileToString);
		List<String> readLines = FileUtils.readLines(new File("H:/test.txt"), "gbk");
		System.out.println(readLines);
		
	}
	
	@Test
	public void test9() throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("H://test.txt")));
		String tmp = null ; 
		while((tmp = bufferedReader.readLine()) != null) {
			System.out.println(new String());
		}
		System.out.println("输出成功");
		bufferedReader.close();
	}

	@Test
	public void test10() throws IOException {
		//测试File类
		File file = new File("H:\\JavaTmpFile\\404.jpg");
		
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.isAbsolute());  //测试这个抽象路径名是否是绝对的。 
		System.out.println(file.getAbsolutePath());  //返回此抽象路径名的绝对路径名字符串。 
		System.out.println(file.getPath()); //将此抽象路径名转换为路径名字符串。
		
		System.out.println("-------------");
		System.out.println(file.toString());  //返回此抽象路径名的路径名字符串。 
		
		File file2 = new File("H:\\JavaTmpFile\\demo\\test.txt");
		file2.mkdirs();
		boolean createNewFile = file2.createNewFile();
		System.out.println(createNewFile);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
