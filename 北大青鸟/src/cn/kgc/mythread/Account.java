package cn.kgc.mythread;
/**
 * 账户类
 * @author zhuhao
 * @date 2019年3月19日
 */
public class  Account {
	private int balance = 500;

	public int getBalance() {
		return balance;
	}
	
	public  void withdraw(int amount) {
		balance = balance - amount;
	}
}
