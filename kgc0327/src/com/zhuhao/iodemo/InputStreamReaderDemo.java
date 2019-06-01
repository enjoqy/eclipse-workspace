package com.zhuhao.iodemo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class InputStreamReaderDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		
//		FileInputStream --> BufferedReader
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("")), "utf-8"));
		
//		FileOutputStream --> BufferedOutputStream
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("")), "utf-8"));
		
	}

}
