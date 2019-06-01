package cn.kgc.demo02;

public class GirlFriend {
	
	private String girl;
	private int age;
	
	public String getGirl() {
		return girl;
	}
	public void setGirl(String girl) {
		this.girl = girl;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public GirlFriend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GirlFriend(String girl, int age) {
		super();
		this.girl = girl;
		this.age = age;
	}
	@Override
	public String toString() {
		return "GirlFriend [girl=" + girl + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((girl == null) ? 0 : girl.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GirlFriend other = (GirlFriend) obj;
		if (age != other.age)
			return false;
		if (girl == null) {
			if (other.girl != null)
				return false;
		} else if (!girl.equals(other.girl))
			return false;
		return true;
	}
	
	
}
