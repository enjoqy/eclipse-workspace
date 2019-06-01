package raky.topic.xml.jdom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.SAXException;

import raky.train.entity.Books;

/**
 * DOM ����   XML�ļ�
 * 
 * read
 * 		1.��������������		���췽�� SAXBuilder()
 * 		2.��ȡdocument����	.build(srcXml)
 * 		3.��ȡ���ڵ����		.getRootElement()
 * 		4.��ȡ�ӽڵ��б�		.getChildren()		
 * 		5.��ȡ�ڵ�����ֵ		.getAttributeValue("id")
 * 		6.��ȡ�ڵ�����			.getName()
 * 		7.��ȡ�ڵ�����			.getValue()
 * 
 * write
 * 		1.�����ĵ�����			���췽�� Document()
 * 		2.�����ڵ����			���췽�� Element("books")	
 * 		3.����Ϊ���ڵ�			.setRootElement(root)	
 * 		4.���ýڵ�����			.setAttribute("id", books.getId()+"")
 * 		5.�����ı�����			���췽��Text(books.getName())
 * 		6.��ӽڵ�����			.addContent(txtAuthor);
 * 
 * http://www.jdom.org/
 * 
 * @author raky
 *
 */
public class XmlJdom {
	
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
	public static List<Books> readXml(String srcXml) throws JDOMException, IOException {
		
		List<Books> booksList = new ArrayList<>();
		
		//1.��������������
		SAXBuilder builder = new SAXBuilder();
		
		//2.��ȡdocument����  JDOMException  IOException
		Document document = builder.build(srcXml);
		
		//3.��ȡroot����
		Element root = document.getRootElement();
		
		//4.��ȡbook�ڵ��б�
		List<?>  books = root.getChildren();
		
		for(Iterator<?> it = books.iterator(); it.hasNext();){
			
			Books entity = new Books();
			
			Element book = (Element)it.next();
			
			String id = book.getAttributeValue("id");
			entity.setId(Integer.valueOf(id));
			
			List<?> nodes = book.getChildren();

			for (Iterator<?> it2 = nodes.iterator(); it2.hasNext();) {
				
				Element node = (Element)it2.next();
				
				String name = node.getName();					
				if(name.equals("name")){
					entity.setName(node.getValue());
				}else if(name.equals("author")){
					entity.setAuthor(node.getValue());
				}else if(name.equals("memo")){
					entity.setMemo(node.getValue());
				}
				
			}			
			booksList.add(entity);
		}	
		return booksList;
	}
	
	
	public static boolean writeXml(List<Books> booksList, String destXml) throws IOException {
		//1.�����ĵ�����
		Document document = new Document();
		
		//2.�������ڵ� root
		Element root = new Element("books");
		document.setRootElement(root);
		
		//3.ѭ������book�ڵ�
		for(int i = 0; i < booksList.size(); i++){
			
			Books books = booksList.get(i);
			
			Element book = new Element("book");
			book.setAttribute("id", books.getId()+"");
			
			Element name = new Element("name");
			Text txtName = new Text(books.getName());
			name.addContent(txtName);
			book.addContent(name);
			
			Element author = new Element("author");
			Text txtAuthor = new Text(books.getAuthor());
			author.addContent(txtAuthor);
			book.addContent(author);
			
			Element memo = new Element("memo");
			Text txtMemo = new Text(books.getMemo());
			memo.addContent(txtMemo);
			book.addContent(memo);
			
			root.addContent(book);
		}
		
		Format format = Format.getPrettyFormat();
		format.setEncoding("utf-8");
		format.setIndent("    ");
		
		XMLOutputter writer = new XMLOutputter(format);
		writer.output(document, new FileOutputStream(destXml));
		
		return true;		
	}

}