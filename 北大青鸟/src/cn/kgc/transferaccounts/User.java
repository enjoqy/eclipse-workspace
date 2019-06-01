package cn.kgc.transferaccounts;
/**
 * 此类是HackerBank的账户类，进行存储个人账户的信息
 * @author zhuhao
 * @date 2019年3月25日
 */

import java.util.UUID;

public class User {

	private String name;
	private long id;
	private double balance;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = CreateID.getID();
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, long id, double balance) {
		super();
		this.name = name;
		this.id = id;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", balance=" + balance + "]";
	}
	
	
}
