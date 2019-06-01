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

	//��ʼ�����ĵ�����xml���ڵ�ʱ���÷���
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		booksList = new ArrayList<>();
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	//��ʼ����ÿ��Ԫ��ʱ�����ø÷���
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		if ("book".equals(qName)) { // ��һ���û�
            for (int i = 0; i < attributes.getLength(); i++) {
                books = new Books();
                if("id".equals(attributes.getLocalName(i))){
                	books.setId(Integer.valueOf(attributes.getValue(i)));
                }
            }
        }
        currentTag = qName; // �ѵ�ǰ��ǩ��¼����	
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

	//����ÿ��Ԫ�ص�����ʱ���ø÷���
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		super.characters(ch, start, length);
		
		String value = new String(ch,start,length); // ����ǰTextNodeת��ΪString
		
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
