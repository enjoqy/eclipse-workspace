package com.zhuhao.iodemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 * @author zhuhao
 * @date 2019年3月27日
 */
public class MyBufferedReaderDemo01 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("H://JavaTmpFile\\test.txt")));
		String str = null;
		while((str = bufferedReader.readLine()) != null) {
			System.out.println(str);
		}
		System.out.println("输出成功");
		bufferedReader.close();
	}

}
