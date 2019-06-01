package cn.kgc.mythread;

import org.junit.Test;

/**
 * 取款的线程类
 * @author zhuhao
 * @date 2019年3月19日
 */
public class TestAcount implements Runnable{

	private Account acount = new Account();

	public void run() {
		for (int i = 0; i < 5; i++) {
			if(acount.getBalance() <= 0) {
				System.out.println("余额不足！");
			}
			makeWithdraw(100);
		}
	}

	private synchronized void makeWithdraw(int amt) {

		if(acount.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() +  " 准备取款");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acount.withdraw(amt);
			System.out.println("完成取款");
		}else {
			System.out.println("余额不足" + Thread.currentThread().getName() + " 余额为 " + acount.getBalance());
		}

	}


}


