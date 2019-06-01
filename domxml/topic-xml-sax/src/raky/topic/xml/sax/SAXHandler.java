package raky.topic.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import raky.train.entity.Books;

public class SAXHandler extends DefaultHandler {
	
	private List<Books> booksList;
	
	private String currentTag;
	
	private Books books;

	//开始解析文档，即xml根节点时调用方法
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		booksList = new ArrayList<>();
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	//开始解析每个元素时，调用该方法
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		if ("book".equals(qName)) { // 是一个用户
            for (int i = 0; i < attributes.getLength(); i++) {
                books = new Books();
                if("id".equals(attributes.getLocalName(i))){
                	books.setId(Integer.valueOf(attributes.getValue(i)));
                }
            }
        }
        currentTag = qName; // 把当前标签记录下来	
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		super.endElement(uri, localName, qName);
		
		if("book".equals(qName)){
			booksList.add(books);
            books = null;
        }
        currentTag = null;

	}

	//解析每个元素的内容时调用该方法
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		super.characters(ch, start, length);
		
		String value = new String(ch,start,length); // 将当前TextNode转换为String
		
		if("name".equals(currentTag)){
			books.setName(value);
		}else if("author".equals(currentTag)){
			books.setAuthor(value);
		}else if("memo".equals(currentTag)){
			books.setMemo(value);
		}
			
	}
	
	
	public List<Books> getList() {
        return booksList;
    }

	
	

}
