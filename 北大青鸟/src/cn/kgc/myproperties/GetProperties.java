package cn.kgc.myproperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 从.properties配置文件中读取内容
 * 
 * @author zhuhao
 * @date 2019年3月16日
 */
public class GetProperties {
	
	public static void main(String[] args) throws IOException {
		
		//创建Properties对象
		Properties p = new Properties();
		
		//类名.class.getClassLoader().getResourceAsStream(properties文件名);
		InputStream is = GetProperties.class.getClassLoader().getResourceAsStream("testproperties.properties");
		
		//从输入流中读取属性列表（键和元素对）。通过对指定的文件（testproperties.properties 文件）进行装载获取，指定文件默认放在src下面
		p.load(is);
		
		String str = p.getProperty("11");
		System.out.println(str);
		
	}

}
