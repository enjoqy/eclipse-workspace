package cn.kgc.myio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BufferedReaderTest0327 {
	
	public static void main(String[] args) throws IOException {
		File file = new File("");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("hacker.hh")));
		int c = 0;
		while(( c = bufferedReader.read()) != -1) {
			System.out.println(c);
		}
	}

}
