package cn.kgc.myio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyBufferedReader {
	public static void main(String[] args) throws IOException {
		try {
			FileReader fr = new FileReader("f://tmp//demo//hello.txt");
			String dir = "f://tmp//demo//hello.txt";
//			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dir), "gbk"));
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("文件不存在");
			e.printStackTrace();
		}
		
		
	}

}
