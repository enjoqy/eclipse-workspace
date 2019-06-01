package com.zhuhao.iotrain;

import java.io.File;
import java.io.IOException;

/**
 * 
 * * 1. 在电脑D盘下创建一个文件为HelloWorld.txt文件， 判断他是文件还是目录， 再创建一个目录IOTest,
 * 之后将HelloWorld.txt移动到IOTest目录下去； 之后遍历IOTest这个目录下的文件
 * 
 * 程序分析： 1、文件创建使用File的createNewFile()方法 2、判断是文件用isFile(),判断是目录用isDirectory
 * 3、创建目录用：mkdirs()方法 4、移动文件用：renameTo
 * 5、遍历目录用：list（）方法获得存放文件的数组，foreach遍历的方法把文件打印出来
 * 
 * @author zhuhao
 * @date 2019年3月28日
 */
public class RenameToFile {

	public static void main(String[] args) {

		File file = new File("H:\\HelloWorld.txt");

		// 创建文件
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("文件创建成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("文件已存在");
		}
//
		// 判断文件是文件还是目录
		if (file.isDirectory()) {
			System.out.println("这是一个目录");
		} else {
			System.out.println("这个是文件");
		}
//
		// 创建一个目录，将HelloWorld.txt移动到新建目录
		File file2 = new File("H:\\JavaTmpFile\\IOTest\\b.txt");
//		file2.mkdirs();

		// 移动文件
		if (file.renameTo(file2)) {
			System.out.println("文件移动成功");
		} else {
			System.out.println("文件移动失败");
		}

		File file3 = new File("H:\\JavaTmpFile\\");
		
		//遍历文件
		String[] list = file3.list();
		System.out.println(list);
		for (String string : list) {
			System.out.println(string + "\t");
		}

	}

}
