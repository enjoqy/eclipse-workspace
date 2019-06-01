package cn.kgc.utlis;

import java.io.File;

import org.junit.Test;

/**
 * 递归列出一个目录下的所有文件，另外一种写法，可作为参考
 * 
 * 程序运行会报空指针异常。。。
 * 
 * @author zhuhao
 * @date 2019年3月17日
 */
public class ListAllFiles {
	
	static long folderSum = 0;  //文件夹计数
	static long fileSum = 0;  //文件计数
	
	public static void listAllFiles(File dir) {
		if(dir == null || !dir.exists()) {
			return;
		}
		if(dir.isFile()) {
			fileSum++;
			System.out.println(dir);
			return;
		}
		for (File file : dir.listFiles()) {
			listAllFiles(file);
		}
		
	}
	
	@Test
	public void demo() {
		File dir = new File("h:");
		listAllFiles(dir);
	}

}
