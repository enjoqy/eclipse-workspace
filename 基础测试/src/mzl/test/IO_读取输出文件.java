package mzl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IO_��ȡ����ļ� {

	public static void main(String[] args) throws IOException {

		File f = new File("F:\\b.txt");  //�����ļ�·��
		
		FileInputStream fis = new FileInputStream(f);  //�ļ������� �����뵽���棩
		InputStreamReader reader = new InputStreamReader(fis, "GBK");  //�����ȡ�������������У�ָ���ַ�����

		StringBuffer str = new StringBuffer();  //�½��ɱ��ַ���
		
		while(reader.ready()) {  //���Ƿ�ɶ�ȡΪ�ж�����
			str.append((char)reader.read());  //ת��char�ӵ�StringBuffer������
		}
		
		InputStream is = new FileInputStream(f);
		System.out.println(is.available());  //���ؿɶ�ȡ���ַ�����  ��������һ�ζԴ����������õķ������Բ��������شӴ���������ȡ���ֽ���������һ������ֵ��
		
		
		for(int i=0; i<str.length(); i++) {  //ѭ�����
			System.out.println(str.charAt(i));  //����ָ�����������ַ�
			
		}
		System.out.println(str.toString());
		
		reader.close();  //�رն�ȡ��
		fis.close();  //�ر����������ͷ�ϵͳ��Դ


		File fo = new File("F:\\a.txt");  //�����ļ�·��
		
		FileOutputStream fos = new FileOutputStream(fo);  //�ļ���������ӻ��������ָ��·���µ��ļ��У�
		OutputStreamWriter writer = new OutputStreamWriter(fos, "GBK");  //���д������ͬʱָ���ļ����뷽ʽ
		writer.append(str);  //��str������д�뵽������
		
		for(double i=0; i<10000; i++) {
		writer.append("\r\n");
		writer.append("English");
		}
		
		writer.close();  //�ر�д������ͬʱ�ѻ���������д���ļ���
		fos.close();  //�ر��ļ���������ͷ���Դ

		

	}

}
