package cn.kgc.myserializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * serializable 序列化
 * Java 提供了一种对象序列化的机制，该机制中，一个对象可以被表示为一个字节序列，该字节序列包括该对象的数据、有关对象的类型的信息和
 * 存储在对象中数据的类型。
 * 将序列化对象写入文件之后，可以从文件中读取出来，并且对它进行反序列化，也就是说，对象的类型信息、对象的数据，还有对象中的数据类
 * 可以用来在内存中新建对象。
 * 整个过程都是 Java 虚拟机（JVM）独立的，也就是说，在一个平台上序列化的对象可以在另一个完全不同的平台上反序列化该对象
 * 类 ObjectInputStream 和 ObjectOutputStream 是高层次的数据流，它们包含反序列化和序列化对象的方法
 * 
 * 请注意，一个类的对象要想序列化成功，必须满足两个条件：
 * 该类必须实现 java.io.Serializable 对象。
 * 该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的。
 * 
 * @author zhuhao
 * @date 2019年3月18日
 */
public class MySerializable {

	/*
	 * 序列化对象
	 * 如果一个可序列化的类，有多个父类（包括直接或间接父类），则这些父类要么是可序列化的，要么有无参构造器，否则会抛出异常
	 * 
	 */
	@Test
	public void test01() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = null;
		File f = new File("h:\\JavaTmpFile\\ser.txt");
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			Demo d = new Demo();
			oos.writeObject(d);
			System.out.println("序列化文件成功，输出的文件夹为：" + f.getPath());
		}finally {
			if(oos != null) {
				oos.close();
			}
		}
	}

	/*
	 * 序列化多个对象，用数组接收
	 * 
	 */
	@Test
	public void test02() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = null;
		File f = new File("h:\\JavaTmpFile\\ser01.txt");

		/*
		 *Demo中的属性已经被transient关键字修饰，不能被序列化了，通过构造方法传入的实参并不能保存 
		 */
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			Demo d = new Demo("ddd", 11, 'd');
			Demo01 d1 = new Demo01();
			ArrayList l = new ArrayList();
			l.add(d);
			l.add(d1);

			//对象序列化写入输入流
			oos.writeObject(l);
			System.out.println("序列化文件成功，输出的文件夹为：" + f.getPath());

		} finally {
			if(oos != null) {
				oos.close();
			}
		}
	}
	
	/*
	 * 反序列化获取信息,如果向文件中写入多个对象，读取的时候就要按照写入的顺序一个一个读取
	 * 同类型的可以用循环读取
	 * 
	 */
	@Test
	public void test03() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = null;
		File f = new File("h:\\JavaTmpFile\\ser01.txt");
		
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			ArrayList l = (ArrayList) ois.readObject();
			
			Demo d = (Demo) l.get(0);
			System.out.println(d);
			
			Demo01 d1 = (Demo01)l.get(1);
			d1.setAge(12);
			d1.setName("xff");
			System.out.println(d1);
			
		} finally {
			if(ois != null)
			ois.close();
		}
		
	}


}
