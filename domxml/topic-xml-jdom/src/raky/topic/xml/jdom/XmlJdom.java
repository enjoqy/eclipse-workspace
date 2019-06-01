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
 * DOM 操作   XML文件
 * 
 * read
 * 		1.创建解析器对象		构造方法 SAXBuilder()
 * 		2.获取document对象	.build(srcXml)
 * 		3.获取根节点对象		.getRootElement()
 * 		4.获取子节点列表		.getChildren()		
 * 		5.获取节点属性值		.getAttributeValue("id")
 * 		6.获取节点名称			.getName()
 * 		7.获取节点内容			.getValue()
 * 
 * write
 * 		1.创建文档对象			构造方法 Document()
 * 		2.创建节点对象			构造方法 Element("books")	
 * 		3.设置为根节点			.setRootElement(root)	
 * 		4.设置节点属性			.setAttribute("id", books.getId()+"")
 * 		5.创建文本对象			构造方法Text(books.getName())
 * 		6.添加节点内容			.addContent(txtAuthor);
 * 
 * http://www.jdom.org/
 * 
 * @author raky
 *
 */
public class XmlJdom {
	
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
	public static List<Books> readXml(String srcXml) throws JDOMException, IOException {
		
		List<Books> booksList = new ArrayList<>();
		
		//1.创建解析器对象
		SAXBuilder builder = new SAXBuilder();
		
		//2.获取document对象  JDOMException  IOException
		Document document = builder.build(srcXml);
		
		//3.获取root对象
		Element root = document.getRootElement();
		
		//4.获取book节点列表
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
		//1.创建文档对象
		Document document = new Document();
		
		//2.创建根节点 root
		Element root = new Element("books");
		document.setRootElement(root);
		
		//3.循环创建book节点
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