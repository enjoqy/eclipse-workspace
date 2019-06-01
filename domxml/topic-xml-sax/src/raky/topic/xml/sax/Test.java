package raky.topic.xml.sax;

import java.util.ArrayList;
import java.util.List;

import raky.train.entity.Books;

/**
 * https://www.cnblogs.com/ygj0930/p/6651643.html
 * 
 * 
 *  һ��DOM��������XML

    ���裺

    1������DocumentBuilder��DocumentBuilder builder=new DocumentBuilder();

    2������dom����Document dom=builder.newDocument();

    3������dom��Ԫ�أ�Element element=dom.createElement("Ԫ����");

    4����Ԫ������ӽڵ㣺element.appendChild(childElement);��dom������ͨ����ͣappendChild�γɵģ�

    5����Ԫ���������ԣ�element.setAttribute("������","����ֵ")��

    6����Ԫ������ı����ݣ�element.setTextContent("��ǩ������");

    7���Ѹ�Ԫ�������dom�У�dom.appendChild(rootElement);�������ӽڵ㶼����ӵ�������µģ����԰Ѹ������ӵ�dom���൱�ڰ����ñ�ǩ����ӽ�dom�ˣ�

    8����dom���󵼳���xml�ļ���

      1������ת����������TransformerFactory  factory=TransformerFactory.newInstance();

      2���ɹ�������ת����ʵ����Transformer transformer=factory.newTransformer();

      3������ת����ʽ��transformer.setOutputProperty(���ԣ�����ֵ);//����������ĵ�ʱ�ĸ�ʽ�����磺���е�

      4����ת������dom��Դת���������������������������ӵ�һ��xml�ļ���transformer.transform(new DOMSourse(dom),new StreamResult(xml_file));

 

    ����SAX��������XML

    ���裺

    1������SAXת����������SAXTransformerFactory  factory=SAXTransformerFactory.newInstance();

    2������ת��handler��TransformerHandler handler=factory.newTransformerHandler();

    3����handler����ת������Transformer transformer=handler.getTransformer();

    4������ת����ʽ��transformer.setOutputProperty(���ԣ�����ֵ);//����������ĵ�ʱ�ĸ�ʽ�����磺���е�

    5������Result���ӵ�xml�ļ���Result res=new StreamResult��new FileOutputStream(xml_file)��;

    6������result��handler��handler.setResult(res)��

    7������handler����xml�ļ���

     1����dom����handler.startDocument();

     2������Ԫ��:handler.startElement(uri,�����ռ�,Ԫ����,�����б�);//û������null

     3�������ӽ�㣺handler.startElement(uri,�����ռ�,��Ԫ����,�����б�);//��һ��start��end��Ԫ��֮����ӵĽ����������ӽڵ�

     4��Ϊ����������:����start��Ԫ���� element.setAttribute("",""��"������"��"����ֵ");

     5��Ϊ�������ı����ݣ���һ��element��start��end֮�䣬handler.characters(byte[]��start,length)��//byte�����ı����ݣ�������Խ��н�ȡ

     5���������Ԫ�أ�hanlder.endElement("","",Ԫ����);//ǰ����start����������������м�Ҫend����Ӿ��������ǩ��

     6���ر�dom����handler.endDocument();

    ԭ��ͨ��result������xml�ĵ���ͨ��handler��ʼһ����ǩ�����ñ�ǩ���ԡ�����ı�������һ����ǩ��������result�Ӷ��ı�xml�ĵ����ݡ�

 

    ����JDOM��������XML

    ���裺��������㣬�ɸ���㴴��dom����Ȼ��Ӹ���㿪ʼ����dom����������dom����xml�ĵ����ɡ�

    1�����ɸ��ڵ㣺Element root=new Element(���ڵ�����);

    2�����ø�������ԣ�root.setAttribute(������������ֵ);

    3���Ѹ���Ϊ��������dom����Document dom=new Document(root);

    4���Ӹ���㿪ʼ����dom����

    1��������㣺Element element=new Element("�ڵ���")��

    2�����ý�����ԣ�element.setAttribute(������������ֵ);

    3�����ý���ı����ݣ�element.setText(�ı����ݣ�;

    4����ӽ�㵽���ڵ��£�father.addContent(child);

    5��dom��������ϣ����������

    1������XMLOutputer:XMLOutputer outputer=new XMLOutputer(format);//format������ѡ�����Դ���һ��format�������������ʽ�����绻�С������ʽ��

    2��ͨ��outputer��dom���������xml�ĵ���outputer.output(dom,new FileOutputStream(xml_file))��

 

    �ģ�DOM4j����XML

    ���裺

    1������dom����Document dom=new Document();

    2���������ڵ㣺Element rooe=dom.addElement("���ڵ���");

    3��Ϊ������������ԣ�element.setAttribute(������������ֵ);

    4���ɸ���㹹��dom����

    1�������ӽڵ㣺Element element=father.addElement("�ڵ���");

    2�����ý�����ԣ�element.setAttribute(������������ֵ);

    3�����ý���ı����ݣ�element.setText(�ı�����

    5������dom����ϣ���dom���������xml�ļ���

    1������XMLWriter��XMLWriter writer=new XMLWriter��new FileOutputStream(xml_file),format����//format������ѡ�����Դ�һ��format����ָ�������ʽ

    2������������ĵ�ʱ�Ƿ�ת�壺writer.setEscapeText(false);//trueת��

    3��ͨ��writer��dom����д��xml�ĵ��У�wtiter.write(dom);

 * 
 * 
 * �Ƚ��ܽ�

����1.DOM4J������ã���Sun��JAXMҲ����DOM4J��Ŀǰ��࿪Դ��Ŀ�д�������DOM4J���������������HibernateҲ��DOM4J����ȡXML�����ļ�����������ǿ���ֲ�ԣ��ǾͲ���DOM4J��
   2.JDOM��DOM�����ܲ���ʱ���ֲ��ѣ��ڲ���10M�ĵ�ʱ�ڴ��������С�ĵ�����»�ֵ�ÿ���ʹ��DOM��JDOM����ȻJDOM�Ŀ������Ѿ�˵��������������ʽ���а�ǰרע�������⣬���Ǵ����ܹ۵���������ȷʵû��ֵ���Ƽ�֮����
   		���⣬DOM����һ���ǳ��õ�ѡ��DOMʵ�ֹ㷺Ӧ���ڶ��ֱ�����ԡ����������������XML��صı�׼�Ļ�������Ϊ����ʽ���W3C�Ƽ�������ڷǱ�׼��Javaģ����ԣ���������ĳЩ���͵���Ŀ�п���Ҳ��Ҫ��������JavaScript��ʹ��DOM����
   3.SAX���ֽϺã���Ҫ���������ض��Ľ�����ʽ���¼�������һ��SAX��⼴��������XML��������û�����뵽�ڴ棨��Ȼ��XML��������ʱ�����в����ĵ���ʱ�������ڴ��У���
 * 
 * 
 * @author raky
 *
 */
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
		List<Books> booksList = XmlSax.readXml(srcXml);
		booksList.forEach(System.out::println);
		
	}
	
	public static void testWriteXml() throws Exception{
		String destXml = "books2.xml";
		XmlSax.writeXml(booksList, destXml);
	}

	public static void main(String[] args) throws Exception {
//		testWriteXml();
		testReadXml();
	}

}
