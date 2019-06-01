package cn.kgc.myproperties;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * 用代码产生一个properties配置文件
 * 
 * @author zhuhao
 * @date 2019年3月16日
 */
public class CreatProperties {
	
	public static void main(String[] args) throws IOException {
		
		Properties p = new Properties();
		
		p.setProperty("xx", "mm");
		p.setProperty("11", "aa");
		p.setProperty("22", "bb");
		
		PrintStream ps = new PrintStream("testproperties.properties");
		p.store(ps, "这个是自动生成的properties配置文件");
		
		PrintStream ps01 = new PrintStream("test.xml");
		p.storeToXML(ps01, "这个是自动生成的xml配置文件");
		
		
		//这个是io流中的输出文件的一种方式
//		new PrintWriter(new FileWriter("c://aa1.txt"));
	}

}

/*1 配置.properties文件
2 获取输入流的方法
1）FileInputStream fi = new FileInputStream(properties文件路径);

2）InputStream fis = 类名.class.getClassLoader().getResourceAsStream(properties文件名);

3 Properties类中常用的方法
1）.load ( InputStream inStream) ，从输入流中读取属性列表（键和元素对）。通过对指定的文件（比如说上面的 test.properties 文件）进行装载来获

2）.getProperty ( String key) ，   用指定的键在此属性列表中搜索属性。也就是通过参数 key ，得到 key 所对应的 value。

取该文件中的所有键 - 值对。以供 getProperty ( String key) 来搜索。

3）.setProperty ( String key, String value) ，调用 Hashtable 的方法 put 。他通过调用基类的put方法来设置 键 - 值对。

4）.store ( OutputStream out, String comments) ，   以适合使用 load 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。与 load 方法相反，该方法将键 - 值对写入到指定的文件中去。

5）.clear () ，清除所有装载的 键 - 值对。该方法在基类中提供
*/