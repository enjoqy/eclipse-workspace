package raky.topic.xml.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import raky.train.entity.Books;

/**
 * DOM 操作   XML文件
 * 
 * read
 * 		1.创建reader对象		构造方法SAXReader()
 * 		2.获取document对象	.read(srcXml)
 * 		3.获取根节点对象		.getRootElement()
 * 		4.获取所有子节点		.elements()		
 * 		5.获取属性节点的值		.attributeValue("id")
 * 		6.获取节点名称			.getName()
 * 		7.获取元素节点的内容		.getStringValue()
 * 
 * write
 * 		1.创建文档树对象		DocumentHelper.createDocument()
 * 		2.添加根节点			.addElement("books")
 * 		3.添加子节点			.addElement("book")
 * 		4.设置节点属性值		.addAttribute("id", books.getId() + "")
 * 		5.设置节点文本内容		.addText(books.getName())
 * 
 * http://mxdxm.iteye.com/blog/738515
 * 
 * https://dom4j.github.io/
 * 
 * https://www.cnblogs.com/sharpest/p/7877501.html	
 * 
 * @author raky
 *
 */
public class XmlDom4j {
	
	/**
	 * 读取xml文件，保存为List容器
	 * @param srcXml
	 * @return
	 * @throws DocumentException 
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static List<Books> readXml(String srcXml) throws DocumentException {
		
		List<Books> booksList = new ArrayList<>();
		
		//1.创建reader对象
		SAXReader reader = new SAXReader();	
		
		//2.获取document对象    DocumentException
		Document document = reader.read(srcXml);
		
		//3.获取根节点 root
		Element root = document.getRootElement();
		
		//4.获取所有的books子节点
		List<?> books = root.elements();
		
		for(Iterator<?> it = books.iterator();it.hasNext();){
			
			Books entity = new Books();
			
			Element book = (Element)it.next();
			
			String id = book.attributeValue("id");
			entity.setId(Integer.valueOf(id));
			
			List<?> nodes = book.elements();
			for(Iterator<?> it2 = nodes.iterator();it2.hasNext();){
				Element node = (Element)it2.next();
				
				String name = node.getName();					
				if(name.equals("name")){
					entity.setName(node.getStringValue());
				}else if(name.equals("author")){
					entity.setAuthor(node.getStringValue());
				}else if(name.equals("memo")){
					entity.setMemo(node.getStringValue());
				}
				
			}	
			booksList.add(entity);			
		}		
		return booksList;
	}
	
	
	public static boolean writeXml(List<Books> booksList, String destXml) throws IOException {
		
		//1.创建文档树对象
		Document document = DocumentHelper.createDocument();
		
		//2.添加根节点
		Element root = document.addElement("books");
		
		//3.循环加入list中的数据
		for(int i = 0; i < booksList.size(); i++){
			
			Books books = booksList.get(i);	
			
			Element book = root.addElement("book");
			book.addAttribute("id", books.getId() + "");
			
			Element name = book.addElement("name");
			name.addText(books.getName());
			
			Element author = book.addElement("author");
			author.addText(books.getAuthor());
			
			Element memo = book.addElement("memo");
			memo.addText(books.getMemo());
			
		}
		
		OutputFormat format = OutputFormat.createCompactFormat();
		format.setEncoding("utf-8"); //gbk, gb2312
		format.setIndent(true); //设置是否缩进
		format.setIndent("    "); //以四个空格方式实现缩进
		format.setNewlines(true); //设置是否换行
		
        XMLWriter writer = new XMLWriter(new FileWriter(new File(destXml)), format);
        writer.write(document);
        writer.close();		
		
		return true;		
	}

}