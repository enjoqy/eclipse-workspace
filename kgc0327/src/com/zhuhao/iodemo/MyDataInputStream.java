package com.zhuhao.iodemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyDataInputStream {
	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fis = new FileInputStream("f://tmp//employer.ser");
			DataInputStream dis = new DataInputStream(fis);
			FileOutputStream fos = new FileOutputStream("f://tmp//demo//demo.ser");
			DataOutputStream dos = new DataOutputStream(fos);
			int tmp;
			while((tmp=dis.read())!=-1) {
				dos.write(tmp);
			}
			System.out.println("文件写入成功");
			dis.close();
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
