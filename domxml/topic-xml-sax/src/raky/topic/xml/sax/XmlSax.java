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
 * DOM ����   XML�ļ�
 * 
 * read
 * 		1.������������			SAXParserFactory.newInstance()
 * 		2.�õ�������			.newSAXParser()
 * 		3.�����Զ�����������	���췽�� SAXHandler()
 * 		4.����������			���췽�� FileInputStream(srcXml)
 * 		5.������ִ�н�������		parser.parse(is, handler)
 * 		6.��ȡ��������б�		handler.getList()
 * 
 * write
 * 		1.����һ��SAXTransformerFactory����	SAXTransformerFactory.newInstance() ��Ҫǿ������ת��
 * 		2.����TransformerHandler����			factory.newTransformerHandler()
 * 		3.����Transformer����					handler.getTransformer()
 * 		4.�����������							.setOutputProperty(OutputKeys.ENCODING, "utf-8") �����ʽ
 * 											.setOutputProperty(OutputKeys.INDENT, "yes") ����
 * 
 * ����xml������ʽ�ıȽϣ�https://www.cnblogs.com/longqingyang/p/5577937.html
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
	 * ��ȡxml�ļ�������ΪList����
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
		
		//1.������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2.�õ�������       ParserConfigurationException, SAXException
		SAXParser parser = factory.newSAXParser();
		
		//2.�õ������
//		XMLReader reader = parser.getXMLReader();
		
		SAXHandler handler = new SAXHandler();
		
		InputStream is = new FileInputStream(srcXml);
		
		parser.parse(is, handler);
		
		//�������ݴ�����
//      reader.setContentHandler(handler);
        
//      reader.parse(new InputSource(srcXml));
		
		is.close();
		
		return handler.getList();	
	}
	
	
	public static boolean writeXml(List<Books> booksList, String destXml) throws TransformerConfigurationException, FileNotFoundException, SAXException {
		
		//1.����һ��SAXTransformerFactory����
		SAXTransformerFactory  factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		
		//2.����TransformerHandler����       TransformerConfigurationException
		TransformerHandler handler = factory.newTransformerHandler();
		
		//3.����Transformer����
		Transformer transformer = handler.getTransformer();
		
		//�����������
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		//4.����Result����
		Result result = new StreamResult(new FileOutputStream(destXml));
		handler.setResult(result);
		
		//5.д�ĵ���������   SAXException
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