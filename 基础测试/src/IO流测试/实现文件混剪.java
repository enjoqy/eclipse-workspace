package IO������;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ʵ���ļ���� {

	FileOutputStream fileOutputStream = null;
	FileInputStream fileInputStream = null;
	OutputStreamWriter outputStreamWriter = null;
	
	public static void main(String[] args) throws IOException {
		ʵ���ļ���� a = new ʵ���ļ����();
		a.writer();
		a.compound();
		
	}
	
	//ʵ�������ļ���ȡ�������������һ���ļ�
	private void compound() throws IOException {
		String[] filesName = {"F:/test2.txt", "F:/test1.txt"};
		fileOutputStream = new FileOutputStream("F:/�ϲ�.txt");
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
			
//			System.out.println("�ϲ��� " + j + " ��");
//		}
		fileOutputStream.close();
	}
	
	//��TXT�ļ�������ַ���1~999
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
		System.out.println("����ɹ�");
	}
  

}
