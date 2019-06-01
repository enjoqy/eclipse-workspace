package com.zhuhao.serializabledemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * 
 * 
 * @author zhuhao
 * @date 2019年3月28日
 */
public class SerializableDemo {
	
	public static void main(String[] args) {
		Student student = new Student();
		
		ObjectOutputStream oos  = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(new File("h://JavaTmpFile\\student.ser")));
			student.setName("小红");
			student.setAge(18);
			
			oos.writeObject(student);
			
			System.out.println("输出成功");
			
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
