package raky.topic.xml.jdom;

import java.util.ArrayList;
import java.util.List;

import raky.train.entity.Books;

public class Test {
	
	
	private static List<Books> booksList;
	
	static {
		booksList = new ArrayList<>();
		for(int i = 1; i <= 5; i++){
			Books books = new Books(i,"java-"+i, "raky-"+i, "best-" + i);
			booksList.add(books);
		}
	}
	
	public static void testReadXml() throws Exception{
		String srcXml = "books.xml";
		List<Books> booksList = XmlJdom.readXml(srcXml);
		booksList.forEach(System.out::println);
		
	}
	
	public static void testWriteXml() throws Exception{
		String destXml = "books2.xml";
		XmlJdom.writeXml(booksList, destXml);
	}

	public static void main(String[] args) throws Exception {
		testWriteXml();
//		testReadXml();
	}

}
