package 数据结构;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropDemo {
	public static void main(String[] args) {
		Properties capitals = new Properties();
		capitals.put("China", "beijing");
		capitals.put("Japanes", "dongjing");
		capitals.put("USA", "huashengdun");
		Set<?> states = capitals.keySet();
		Iterator<?> itr = states.iterator();
        while(itr.hasNext()) {
        	String s = (String)itr.next();
        	System.out.println(s + "\t" + capitals.getProperty(s));
        }
        System.out.println();
        String str = (String)capitals.getProperty("China");
        System.out.println("capitals " + str);
	}

}
