package mzl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IO_读取输出文件 {

	public static void main(String[] args) throws IOException {

		File f = new File("F:\\b.txt");  //构建文件路径
		
		FileInputStream fis = new FileInputStream(f);  //文件输入流 （输入到缓存）
		InputStreamReader reader = new InputStreamReader(fis, "GBK");  //输入读取流（读到缓存中）指定字符编码

		StringBuffer str = new StringBuffer();  //新建可变字符串
		
		while(reader.ready()) {  //以是否可读取为判断条件
			str.append((char)reader.read());  //转成char加到StringBuffer对象中
		}
		
		InputStream is = new FileInputStream(f);
		System.out.println(is.available());  //返回可读取的字符个数  ，返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取的字节数。返回一个整数值。
		
		
		for(int i=0; i<str.length(); i++) {  //循环输出
			System.out.println(str.charAt(i));  //返回指定索引出的字符
			
		}
		System.out.println(str.toString());
		
		reader.close();  //关闭读取流
		fis.close();  //关闭输入流，释放系统资源


		File fo = new File("F:\\a.txt");  //构建文件路径
		
		FileOutputStream fos = new FileOutputStream(fo);  //文件输出流（从缓存输出到指定路径下的文件中）
		OutputStreamWriter writer = new OutputStreamWriter(fos, "GBK");  //输出写入流，同时指定文件编码方式
		writer.append(str);  //将str的内容写入到缓冲区
		
		for(double i=0; i<10000; i++) {
		writer.append("\r\n");
		writer.append("English");
		}
		
		writer.close();  //关闭写入流，同时把缓冲区内容写到文件中
		fos.close();  //关闭文件输出流，释放资源

		

	}

}
