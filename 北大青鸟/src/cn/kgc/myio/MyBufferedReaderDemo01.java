package cn.kgc.myio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderDemo01 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("H://test.txt")));
		String readLine = bufferedReader.readLine();
		while((readLine) != null) {
			System.out.println(readLine);
		}
		System.out.println("输出成功");
		bufferedReader.close();
	}

}
