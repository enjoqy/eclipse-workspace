package com.huaihao.hibernate.test;

public class User {
	
	/*
	 * hibernatey要求实体类有一个属性是唯一的
	 */
	private int uid;
	private String username;
	private String password;
	private String adress;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String address) {
		this.adress = address;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", adress=" + adress + "]";
	}
	

}
