package cn.kgc.transferaccounts;

public enum Week {

	RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4); 

	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private Week(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
}
