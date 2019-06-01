package cn.kgc.utlis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 计算有d盘有多少文件和文件夹
 * 
 * @author zhuhao
 * @date 2019年3月15日
 */
public class FileCountMain {

	public static void main(String args[]) throws IOException {
		
//		可以重定向控制台输出，可以将文件输出到src目录下
//		PrintStream ps = new PrintStream(new FileOutputStream("src/for.txt"));
//		System.setOut(ps);

		File my = new File("d:" + File.separator); //操作路径 

		System.out.println("文件读取中...");

		double beginTime = System.currentTimeMillis();  //程序开始时的系统时间
		FileCount.print(my);
		double finishTime = System.currentTimeMillis();  //程序结束时的系统时间

		System.out.println("文件夹总数为： " + FileCount.folderSum + "个");
		System.out.println("文件总数为： " + FileCount.fileSum + "个");
		System.out.println("读取完毕......共计用时： " + (finishTime - beginTime) + " 毫秒");
	}

}
