package com.zhuhao.iodemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 复制文件
 * @author zhuhao
 * @date 2019年3月28日
 */
public class Demo01 {

	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(new File("H:\\JavaTmpFile\\movie.mp4"));
			fileOutputStream = new FileOutputStream(new File("src\\movie1.mp4"));
			int tmp = 0;
//		
//		while((tmp = fileInputStream.read()) != -1) {
//			fileOutputStream.write(tmp);
//		}

			byte[] bs = new byte[1024];

			while ((tmp = fileInputStream.read(bs)) != -1) {
				fileOutputStream.write(bs);

			}

			System.out.println("输入成功");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
