package raky.topic.xml.sax;

import java.util.ArrayList;
import java.util.List;

import raky.train.entity.Books;

/**
 * https://www.cnblogs.com/ygj0930/p/6651643.html
 * 
 * 
 *  一：DOM方法生成XML

    步骤：

    1：创建DocumentBuilder：DocumentBuilder builder=new DocumentBuilder();

    2：创建dom对象：Document dom=builder.newDocument();

    3：创建dom中元素：Element element=dom.createElement("元素名");

    4：向元素添加子节点：element.appendChild(childElement);（dom树就是通过不停appendChild形成的）

    5：向元素设置属性：element.setAttribute("属性名","属性值")；

    6：向元素添加文本内容：element.setTextContent("标签间内容");

    7：把根元素添加至dom中：dom.appendChild(rootElement);（由于子节点都是添加到根结点下的，所以把根结点添加到dom就相当于把整棵标签树添加进dom了）

    8：把dom对象导出到xml文件：

      1）创建转换器工厂：TransformerFactory  factory=TransformerFactory.newInstance();

      2）由工厂创建转换器实例：Transformer transformer=factory.newTransformer();

      3）设置转换格式：transformer.setOutputProperty(属性，属性值);//设置输出到文档时的格式，比如：换行等

      4）由转换器把dom资源转换到结果输出流，而结果输出流连接到一个xml文件：transformer.transform(new DOMSourse(dom),new StreamResult(xml_file));

 

    二：SAX方法操作XML

    步骤：

    1：创建SAX转换器工厂：SAXTransformerFactory  factory=SAXTransformerFactory.newInstance();

    2：创建转换handler：TransformerHandler handler=factory.newTransformerHandler();

    3：由handler创建转换器：Transformer transformer=handler.getTransformer();

    4：设置转换格式：transformer.setOutputProperty(属性，属性值);//设置输出到文档时的格式，比如：换行等

    5：创建Result连接到xml文件：Result res=new StreamResult（new FileOutputStream(xml_file)）;

    6：关联result到handler：handler.setResult(res)；

    7：利用handler操作xml文件：

     1）打开dom对象：handler.startDocument();

     2）创建元素:handler.startElement(uri,命名空间,元素名,属性列表);//没有则填null

     3）创建子结点：handler.startElement(uri,命名空间,子元素名,属性列表);//在一个start与end的元素之间添加的结点就是它的子节点

     4）为结点添加属性:上面start的元素名 element.setAttribute("",""，"属性名"，"属性值");

     5）为结点添加文本内容：在一个element的start与end之间，handler.characters(byte[]，start,length)；//byte就是文本内容，后面可以进行截取

     5）镜像结束元素：hanlder.endElement("","",元素名);//前面有start，操作完这个结点后切记要end，添加镜像结束标签。

     6）关闭dom对象：handler.endDocument();

    原理：通过result关联到xml文档，通过handler开始一个标签、设置标签属性、添加文本、结束一个标签方法操作result从而改变xml文档内容。

 

    三：JDOM方法生成XML

    步骤：创建根结点，由根结点创建dom对象，然后从根结点开始构造dom树，最后输出dom对象到xml文档即可。

    1：生成根节点：Element root=new Element(“节点名”);

    2：设置根结点属性：root.setAttribute(属性名，属性值);

    3：把根作为参数创建dom对象：Document dom=new Document(root);

    4：从根结点开始构造dom树：

    1）创建结点：Element element=new Element("节点名")；

    2）设置结点属性：element.setAttribute(属性名，属性值);

    3）设置结点文本内容：element.setText(文本内容）;

    4）添加结点到父节点下：father.addContent(child);

    5：dom树构造完毕，进行输出：

    1）创建XMLOutputer:XMLOutputer outputer=new XMLOutputer(format);//format参数可选，可以创建一个format对象设置输出格式，比如换行、编码格式等

    2）通过outputer把dom对象输出到xml文档：outputer.output(dom,new FileOutputStream(xml_file))；

 

    四：DOM4j生成XML

    步骤：

    1：创建dom对象：Document dom=new Document();

    2：创建根节点：Element rooe=dom.addElement("根节点名");

    3：为根结点设置属性：element.setAttribute(属性名，属性值);

    4：由根结点构建dom树：

    1）创建子节点：Element element=father.addElement("节点名");

    2）设置结点属性：element.setAttribute(属性名，属性值);

    3）设置结点文本内容：element.setText(文本）；

    5：构建dom树完毕，把dom对象输出到xml文件：

    1）创建XMLWriter：XMLWriter writer=new XMLWriter（new FileOutputStream(xml_file),format）；//format参数可选，可以传一个format对象指定输出格式

    2）设置输出到文档时是否转义：writer.setEscapeText(false);//true转义

    3）通过writer把dom对象写到xml文档中：wtiter.write(dom);

 * 
 * 
 * 比较总结

　　1.DOM4J性能最好，连Sun的JAXM也在用DOM4J。目前许多开源项目中大量采用DOM4J，例如大名鼎鼎的Hibernate也用DOM4J来读取XML配置文件。如果不考虑可移植性，那就采用DOM4J。
   2.JDOM和DOM在性能测试时表现不佳，在测试10M文档时内存溢出。在小文档情况下还值得考虑使用DOM和JDOM。虽然JDOM的开发者已经说明他们期望在正式发行版前专注性能问题，但是从性能观点来看，它确实没有值得推荐之处。
   		另外，DOM仍是一个非常好的选择。DOM实现广泛应用于多种编程语言。它还是许多其它与XML相关的标准的基础，因为它正式获得W3C推荐（与基于非标准的Java模型相对），所以在某些类型的项目中可能也需要它（如在JavaScript中使用DOM）。
   3.SAX表现较好，这要依赖于它特定的解析方式－事件驱动。一个SAX检测即将到来的XML流，但并没有载入到内存（当然当XML流被读入时，会有部分文档暂时隐藏在内存中）。
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
