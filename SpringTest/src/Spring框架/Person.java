package Spring¿ò¼Ü;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	
	private String person;

	

	public void setPerson(String person) {
		this.person = person;
	}
	
	private String[] str;
	private List<String> list;
	private Map<String, String> map;
	private Properties properties;
	
	public void setStr(String[] str) {
		this.str = str;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public void test() {
		System.out.println("person....... " + person);
		System.out.println("str....... " + str);
		System.out.println("list....... " + list);
		System.out.println("map....... " + map);
		System.out.println("properties....... " + properties);
		
	}

}
