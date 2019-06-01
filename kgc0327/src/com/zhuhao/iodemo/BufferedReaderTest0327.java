package com.zhuhao.iodemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
/**
 * 测试BufferedReader,进行拷贝文件
 * 
 * @author zhuhao
 * @date 2019年3月27日
 */
public class BufferedReaderTest0327 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("H:\\test.txt")), "gbk"));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("H:\\test11.txt")), "utf-8"));
		
		String str = null;
		
		while((str = bufferedReader.readLine()) != null) {
			bufferedWriter.write(str);
		}
		
		System.out.println("输出成功");
		
		bufferedWriter.close();
		bufferedReader.close();
	}

}
