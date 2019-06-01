package cn.kgc.utlis;

import java.io.File;

public class FileCount {

	static long folderSum = 0;  //文件夹计数
	static long fileSum = 0;  //文件计数

	public static void print(File file) {  //递归调用此方法

		if (file != null && file.isDirectory()) {   //判断是否是目录  &&这个是'短路且'   ||这个是'短路或'
			folderSum++;  //文件夹计数+1
			File[] f = file.listFiles();  //如果是目录，则列出全部的内容
			if (f != null) {
				for (int i = 0; i < f.length; i++ ) {
					print(f[i]);
					fileSum++;  //文件计数+1
				}
			}
		}else{                              //如果不是目录，则直接打印路径信息
			System.out.println(file);
			
			
		}

	}
}