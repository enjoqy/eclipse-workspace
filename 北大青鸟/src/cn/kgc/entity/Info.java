package cn.kgc.entity;

public class Info{ 
	private Integer id;
	private String name;
	private Integer age;
	private String sex;
	private String adress;
	private Integer phone;

	public Info(){

	}

	public Info(Integer id, String name, Integer age, String sex, String adress, Integer phone){
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.adress = adress;
		this.phone = phone;
 	}

	public Integer getId(){
		return id;
	};

	public void setId(Integer id){
		this.id = id;
	}

	public String getName(){
		return name;
	};

	public void setName(String name){
		this.name = name;
	}

	public Integer getAge(){
		return age;
	};

	public void setAge(Integer age){
		this.age = age;
	}

	public String getSex(){
		return sex;
	};

	public void setSex(String sex){
		this.sex = sex;
	}

	public String getAdress(){
		return adress;
	};

	public void setAdress(String adress){
		this.adress = adress;
	}

	public Integer getPhone(){
		return phone;
	};

	public void setPhone(Integer phone){
		this.phone = phone;
	}
	
}