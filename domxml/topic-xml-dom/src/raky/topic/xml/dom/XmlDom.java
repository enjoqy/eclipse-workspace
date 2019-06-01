package raky.topic.xml.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import raky.train.entity.Books;

/**
 * DOM 操作   XML文件
 * 
 * read
 * 		1.获取解析工厂对象	DocumentBuilderFactory.newInstance()
 * 		2.获取解析器对象	.newDocumentBuilder()
 * 		3.获取文档对象		.parse(new FileInputStream(new File(srcXml)))
 * 		4.获取根节点		.getDocumentElement()
 * 		5.获取子节点列表	.getChildNodes()
 * 		6.判断节点类型
 * 			属性节点		.getAttributes()
 * 			元素节点		.getFirstChild()
 * 
 * write
 * 		1.获取解析工厂对象	.newInstance()
 * 		2.获取解析器对象	.newDocumentBuilder()
 * 		3.创建文档对象		.newDocument()
 * 		4.创建根节点		.createElement("books")
 * 		5.挂载到文档对象	.appendChild(root)
 * 		6.创建文本节点		.createTextNode(books.getName())
 *
 * http://mxdxm.iteye.com/blog/738515	
 * 
 * @author raky
 *
 */
public class XmlDom {
	
	/**
	 * 读取xml文件，保存为List容器
	 * @param srcXml
	 * @return
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static List<Books> readXml(String srcXml) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
		
		List<Books> booksList = new ArrayList<>();
		
		//1.创建dom解析工厂对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//2.获取dom解析器对象  （ParserConfigurationException）
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//3.获取文档对象，读取xml源文件
		Document document = builder.parse(new FileInputStream(new File(srcXml)));
		
		//4.获取根元素、根节点  root
		Element root = document.getDocumentElement();
		
		//5.获取子节点    books 列表
		NodeList books = root.getChildNodes();
		
		if(books != null && books.getLength() > 0){ //是否有子节点
			
			for(int index = 0; index < books.getLength(); index++){
			
				Node book = books.item(index); //子节点     books
				
				//判断节点类型
				if(book.getNodeType() == Node.ELEMENT_NODE){	
					
					Books entity = new Books();
				
					//属性节点
					NamedNodeMap maps = book.getAttributes();					
					if(maps != null && maps.getLength() > 0){
						String id = maps.getNamedItem("id").getNodeValue();
						entity.setId(Integer.valueOf(id));
					}
					
					//元素节点
					for(Node node = book.getFirstChild(); node != null; node = node.getNextSibling()){//循环获取节点信息
						
						if(node.getNodeType() == Node.ELEMENT_NODE){	//根据节点名称赋值						
							String value = node.getFirstChild().getNodeValue();					
							if(node.getNodeName().equals("name")){
								entity.setName(value);
							}else if(node.getNodeName().equals("author")){
								entity.setAuthor(value);
							}else if(node.getNodeName().equals("memo")){
								entity.setMemo(value);
							}						
						}
					}
				
					booksList.add(entity);
				}
			}
		}
		
		return booksList;
	}
	
	
	public static boolean writeXml(List<Books> booksList, String destXml) throws ParserConfigurationException, TransformerException{
		
		//1.创建dom解析工厂对象
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		//2.获取dom解析器对象  （ParserConfigurationException）
		DocumentBuilder builder=factory.newDocumentBuilder();
		
		//3.创建一个文档对象
		Document document = builder.newDocument();
		
		//4.创建根元素，挂载到文档对象中
		Element root = 	document.createElement("books");
		document.appendChild(root);
		
		//5.把booksList里面的数据保存到xml中
		for(int i = 0; i < booksList.size(); i++){
			
			Books books = booksList.get(i);
			
			//创建book元素(标签)
			Element book = document.createElement("book");
			book.setAttribute("id", books.getId()+"");
			
			//创建book - name标签 - 文本节点
			Element name = document.createElement("name");
			Text txtName = document.createTextNode(books.getName());
			name.appendChild(txtName);
			book.appendChild(name);
			
			//创建book - author标签- 文本节点
			Element author = document.createElement("author");
			Text txtAuthor = document.createTextNode(books.getAuthor());
			author.appendChild(txtAuthor);
			book.appendChild(author);
			
			//创建book - memo标签- 文本节点
			Element memo = document.createElement("memo");
			Text txtMemo = document.createTextNode(books.getMemo());
			memo.appendChild(txtMemo);
			book.appendChild(memo);
			
			root.appendChild(book);
		}
		
		//保存xml文件
		TransformerFactory tfactory = TransformerFactory.newInstance(); 
//		tfactory.setAttribute("indent-number", new Integer(2));
		Transformer transformer = tfactory.newTransformer();  //TransformerConfigurationException
//		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		DOMSource xmlSource = new DOMSource(document);
		StreamResult outputTarget = new StreamResult(new File(destXml));
		
		//设置编码类型
		transformer.setOutputProperty("encoding","UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		//dom树转换成xml文件
		transformer.transform(xmlSource, outputTarget); //TransformerException
		
		return true;		
	}

}