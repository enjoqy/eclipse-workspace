package IO流测试;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 实现文件混剪 {

	FileOutputStream fileOutputStream = null;
	FileInputStream fileInputStream = null;
	OutputStreamWriter outputStreamWriter = null;
	
	public static void main(String[] args) throws IOException {
		实现文件混剪 a = new 实现文件混剪();
		a.writer();
		a.compound();
		
	}
	
	//实现两个文件读取并且输出到另外一个文件
	private void compound() throws IOException {
		String[] filesName = {"F:/test2.txt", "F:/test1.txt"};
		fileOutputStream = new FileOutputStream("F:/合并.txt");
		byte[] by = new byte[1024];
		
//		for(int j=0; j<10; j++) {
			int count = 0;
			for(int i=0; i<2; i++) {
				fileInputStream = new FileInputStream(filesName[i]);
				fileInputStream.skip(10);
				while((fileInputStream.read(by)) != -1) {
					fileOutputStream.write(by);
					count++;
					if(count == 2) {
						break;
					}
					
				}
				
			}
			
//			System.out.println("合并了 " + j + " 次");
//		}
		fileOutputStream.close();
	}
	
	//往TXT文件中添加字符串1~999
	private  void writer() throws IOException {
		File file = new File("F:/test2.txt");
		outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
		
		String[] str = new String[1000];
		for(int i=0; i<1000; i++) {
			String a = "A" + i;
			str[i] = a;
			System.out.println(str[i]);
		}
		for(int i=0; i<1000; i++) {
			
			outputStreamWriter.append(str[i] + "\r\n");
		}
		outputStreamWriter.close();
		System.out.println("输出成功");
	}
  

}
