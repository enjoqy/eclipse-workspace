package cn.kgc.myserializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 重定向控制台输出
 * 
 * @author zhuhao
 * @date 2019年3月18日
 */
public class MySystemSetOut {

	public static void main(String[] args) throws IOException {
		File f = new File("h:\\hello.txt");
		PrintStream ps = new PrintStream(new FileOutputStream(f, true));
		System.setErr(ps);  //重定向err输出，正常的可以在控制台打印
        System.setOut(ps);  //重定向控制台的所有输出
        
	}

}