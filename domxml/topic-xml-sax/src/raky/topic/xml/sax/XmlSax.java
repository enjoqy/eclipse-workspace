package raky.topic.xml.sax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import raky.train.entity.Books;

/**
 * DOM 操作   XML文件
 * 
 * read
 * 		1.创建解析工厂			SAXParserFactory.newInstance()
 * 		2.得到解析器			.newSAXParser()
 * 		3.创建自定义解析类对象	构造方法 SAXHandler()
 * 		4.创建输入流			构造方法 FileInputStream(srcXml)
 * 		5.解析器执行解析方法		parser.parse(is, handler)
 * 		6.获取解析结果列表		handler.getList()
 * 
 * write
 * 		1.创建一个SAXTransformerFactory对象	SAXTransformerFactory.newInstance() 需要强制类型转换
 * 		2.创建TransformerHandler对象			factory.newTransformerHandler()
 * 		3.创建Transformer对象					handler.getTransformer()
 * 		4.设置输出属性							.setOutputProperty(OutputKeys.ENCODING, "utf-8") 编码格式
 * 											.setOutputProperty(OutputKeys.INDENT, "yes") 换行
 * 
 * 四种xml解析方式的比较：https://www.cnblogs.com/longqingyang/p/5577937.html
 * 
 * https://blog.csdn.net/lp284558195/article/details/79136322
 * 
 * https://blog.csdn.net/heligui/article/details/78423580
 * 
 * https://www.cnblogs.com/xiaxj/p/5905108.html
 * 
 * https://www.cnblogs.com/ygj0930/p/6651643.html
 * 
 * @author redyin
 *
 */
public class XmlSax {
	
	/**
	 * 读取xml文件，保存为List容器
	 * @param srcXml
	 * @return
	 * @throws JDOMException 
	 * @throws DocumentException 
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static List<Books> readXml(String srcXml) throws ParserConfigurationException, SAXException, IOException  {
		
		//1.创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2.得到解析器       ParserConfigurationException, SAXException
		SAXParser parser = factory.newSAXParser();
		
		//2.得到解读器
//		XMLReader reader = parser.getXMLReader();
		
		SAXHandler handler = new SAXHandler();
		
		InputStream is = new FileInputStream(srcXml);
		
		parser.parse(is, handler);
		
		//设置内容处理器
//      reader.setContentHandler(handler);
        
//      reader.parse(new InputSource(srcXml));
		
		is.close();
		
		return handler.getList();	
	}
	
	
	public static boolean writeXml(List<Books> booksList, String destXml) throws TransformerConfigurationException, FileNotFoundException, SAXException {
		
		//1.创建一个SAXTransformerFactory对象
		SAXTransformerFactory  factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		
		//2.创建TransformerHandler对象       TransformerConfigurationException
		TransformerHandler handler = factory.newTransformerHandler();
		
		//3.创建Transformer对象
		Transformer transformer = handler.getTransformer();
		
		//设置输出属性
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		//4.创建Result对象
		Result result = new StreamResult(new FileOutputStream(destXml));
		handler.setResult(result);
		
		//5.写文档具体内容   SAXException
		handler.startDocument();
		
		handler.startElement(null, null, "books", null);
		
		for(int i = 0; i < booksList.size(); i++){
			
			Books books = booksList.get(i);
			
			AttributesImpl attrs = new AttributesImpl();
			attrs.addAttribute(null, null, "id", null, books.getId() + "");
			
			handler.startElement(null, null, "book", attrs);
//			attrs.clear();
			
			handler.startElement(null, null, "name", null);
			handler.characters(books.getName().toCharArray(), 0, books.getName().length());
			handler.endElement(null, null, "name");
			
			handler.startElement(null, null, "author", null);
			handler.characters(books.getAuthor().toCharArray(), 0, books.getAuthor().length());
			handler.endElement(null, null, "author");
			
			handler.startElement(null, null, "memo", null);
			handler.characters(books.getMemo().toCharArray(), 0, books.getMemo().length());
			handler.endElement(null, null, "memo");
			
			
			handler.endElement(null, null, "book");
			
		}
		
		handler.endElement(null, null, "books");
		handler.endDocument();	
	
		return true;		
	}

}