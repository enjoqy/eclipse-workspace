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
 * DOM ����   XML�ļ�
 * 
 * read
 * 		1.����reader����		���췽��SAXReader()
 * 		2.��ȡdocument����	.read(srcXml)
 * 		3.��ȡ���ڵ����		.getRootElement()
 * 		4.��ȡ�����ӽڵ�		.elements()		
 * 		5.��ȡ���Խڵ��ֵ		.attributeValue("id")
 * 		6.��ȡ�ڵ�����			.getName()
 * 		7.��ȡԪ�ؽڵ������		.getStringValue()
 * 
 * write
 * 		1.�����ĵ�������		DocumentHelper.createDocument()
 * 		2.��Ӹ��ڵ�			.addElement("books")
 * 		3.����ӽڵ�			.addElement("book")
 * 		4.���ýڵ�����ֵ		.addAttribute("id", books.getId() + "")
 * 		5.���ýڵ��ı�����		.addText(books.getName())
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
	 * ��ȡxml�ļ�������ΪList����
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
		
		//1.����reader����
		SAXReader reader = new SAXReader();	
		
		//2.��ȡdocument����    DocumentException
		Document document = reader.read(srcXml);
		
		//3.��ȡ���ڵ� root
		Element root = document.getRootElement();
		
		//4.��ȡ���е�books�ӽڵ�
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
		
		//1.�����ĵ�������
		Document document = DocumentHelper.createDocument();
		
		//2.��Ӹ��ڵ�
		Element root = document.addElement("books");
		
		//3.ѭ������list�е�����
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
		format.setIndent(true); //�����Ƿ�����
		format.setIndent("    "); //���ĸ��ո�ʽʵ������
		format.setNewlines(true); //�����Ƿ���
		
        XMLWriter writer = new XMLWriter(new FileWriter(new File(destXml)), format);
        writer.write(document);
        writer.close();		
		
		return true;		
	}

}