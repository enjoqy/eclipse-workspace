package –Ú¡–ªØ;

import java.io.Serializable;

public class Employee implements Serializable{
	public String name;
	public int age;
	public String address;
	public int number;
	public void mailCheck() {
		System.out.println("Maling a check to " + name + " " + address);
	}

}
