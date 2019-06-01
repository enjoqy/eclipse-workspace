package cn.kgc.myio;

import java.io.File;
import java.io.IOException;

public class FileMethods {
	public static void main(String[] args) throws IOException {
		FileMethods fm = new FileMethods();
		File f = new File("f:\\tmp\\demo\\test.txt");
		System.out.println(f.mkdirs());
		fm.create(f);
		fm.deelete(f);
		System.out.println(f.getAbsolutePath());
		System.out.println(f.isDirectory());
		System.out.println(f.getPath());
		System.out.println(f.toString());
		System.out.println(f.length());
		
	}
	
	public void create(File file) throws IOException {
		if(!file.exists()) {
			file.createNewFile();
			System.out.println("文件创建成功");
		}
	}
	
	public void deelete(File file) throws IOException{
		if(file.exists()) {
			file.delete();
			System.out.println("文件删除成功");
		}
	}
}
