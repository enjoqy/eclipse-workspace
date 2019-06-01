package ���л�;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "С��";
		e.age = 88;
		e.address = "China";
		e.number = 8848;
		
		File f  = new File("F:\\tmp\\");
		if(!f.exists()) {
			System.out.println("·�������ڣ�����һ��");
			f.mkdirs();
			System.out.println("������·��Ϊ�� " + f);
		}
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:\\tmp\\Employee.ser"));
			out.writeObject(e);
			out.close();
			System.out.println("Serialized data is saved in F:\\tmp\\Employee.ser");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
