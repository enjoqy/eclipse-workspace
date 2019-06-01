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
 * DOM ����   XML�ļ�
 * 
 * read
 * 		1.��ȡ������������	DocumentBuilderFactory.newInstance()
 * 		2.��ȡ����������	.newDocumentBuilder()
 * 		3.��ȡ�ĵ�����		.parse(new FileInputStream(new File(srcXml)))
 * 		4.��ȡ���ڵ�		.getDocumentElement()
 * 		5.��ȡ�ӽڵ��б�	.getChildNodes()
 * 		6.�жϽڵ�����
 * 			���Խڵ�		.getAttributes()
 * 			Ԫ�ؽڵ�		.getFirstChild()
 * 
 * write
 * 		1.��ȡ������������	.newInstance()
 * 		2.��ȡ����������	.newDocumentBuilder()
 * 		3.�����ĵ�����		.newDocument()
 * 		4.�������ڵ�		.createElement("books")
 * 		5.���ص��ĵ�����	.appendChild(root)
 * 		6.�����ı��ڵ�		.createTextNode(books.getName())
 *
 * http://mxdxm.iteye.com/blog/738515	
 * 
 * @author raky
 *
 */
public class XmlDom {
	
	/**
	 * ��ȡxml�ļ�������ΪList����
	 * @param srcXml
	 * @return
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static List<Books> readXml(String srcXml) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
		
		List<Books> booksList = new ArrayList<>();
		
		//1.����dom������������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//2.��ȡdom����������  ��ParserConfigurationException��
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//3.��ȡ�ĵ����󣬶�ȡxmlԴ�ļ�
		Document document = builder.parse(new FileInputStream(new File(srcXml)));
		
		//4.��ȡ��Ԫ�ء����ڵ�  root
		Element root = document.getDocumentElement();
		
		//5.��ȡ�ӽڵ�    books �б�
		NodeList books = root.getChildNodes();
		
		if(books != null && books.getLength() > 0){ //�Ƿ����ӽڵ�
			
			for(int index = 0; index < books.getLength(); index++){
			
				Node book = books.item(index); //�ӽڵ�     books
				
				//�жϽڵ�����
				if(book.getNodeType() == Node.ELEMENT_NODE){	
					
					Books entity = new Books();
				
					//���Խڵ�
					NamedNodeMap maps = book.getAttributes();					
					if(maps != null && maps.getLength() > 0){
						String id = maps.getNamedItem("id").getNodeValue();
						entity.setId(Integer.valueOf(id));
					}
					
					//Ԫ�ؽڵ�
					for(Node node = book.getFirstChild(); node != null; node = node.getNextSibling()){//ѭ����ȡ�ڵ���Ϣ
						
						if(node.getNodeType() == Node.ELEMENT_NODE){	//���ݽڵ����Ƹ�ֵ						
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
		
		//1.����dom������������
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		//2.��ȡdom����������  ��ParserConfigurationException��
		DocumentBuilder builder=factory.newDocumentBuilder();
		
		//3.����һ���ĵ�����
		Document document = builder.newDocument();
		
		//4.������Ԫ�أ����ص��ĵ�������
		Element root = 	document.createElement("books");
		document.appendChild(root);
		
		//5.��booksList��������ݱ��浽xml��
		for(int i = 0; i < booksList.size(); i++){
			
			Books books = booksList.get(i);
			
			//����bookԪ��(��ǩ)
			Element book = document.createElement("book");
			book.setAttribute("id", books.getId()+"");
			
			//����book - name��ǩ - �ı��ڵ�
			Element name = document.createElement("name");
			Text txtName = document.createTextNode(books.getName());
			name.appendChild(txtName);
			book.appendChild(name);
			
			//����book - author��ǩ- �ı��ڵ�
			Element author = document.createElement("author");
			Text txtAuthor = document.createTextNode(books.getAuthor());
			author.appendChild(txtAuthor);
			book.appendChild(author);
			
			//����book - memo��ǩ- �ı��ڵ�
			Element memo = document.createElement("memo");
			Text txtMemo = document.createTextNode(books.getMemo());
			memo.appendChild(txtMemo);
			book.appendChild(memo);
			
			root.appendChild(book);
		}
		
		//����xml�ļ�
		TransformerFactory tfactory = TransformerFactory.newInstance(); 
//		tfactory.setAttribute("indent-number", new Integer(2));
		Transformer transformer = tfactory.newTransformer();  //TransformerConfigurationException
//		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		DOMSource xmlSource = new DOMSource(document);
		StreamResult outputTarget = new StreamResult(new File(destXml));
		
		//���ñ�������
		transformer.setOutputProperty("encoding","UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		//dom��ת����xml�ļ�
		transformer.transform(xmlSource, outputTarget); //TransformerException
		
		return true;		
	}

}