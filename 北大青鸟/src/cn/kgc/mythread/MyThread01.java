package cn.kgc.mythread;

import org.junit.Test;

/**
 * 测试线程，直接继承
 * 
 * @author zhuhao
 * @date 2019年3月19日
 */
public class MyThread01 extends Thread{
	
	private int count = 0;
	
	public void run() {
		while(count < 10) {
			count++;
			System.out.println(Thread.currentThread().getName() + " " + count);
		}
	}
	
	
	//使用join阻塞指定线程
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
				MyThread01 mt = new MyThread01();
				mt.start();
				mt.join();
			}else {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}
	}
	
	
	@Test
	public void test01() {
		
		System.out.println(Thread.currentThread().getName());
		MyThread01 mt = new MyThread01();
		MyThread01 mt1 = new MyThread01();
		MyThread01 mt2 = new MyThread01();
		mt.start();
		mt1.start();
		mt2.start();
	}
	
	//sleep()方法让线程睡眠，时间到了会自动唤醒
	@Test
	public void test02() throws InterruptedException {
		System.out.println("wait");
		for (int i = 1; i <= 5; i++) {
			System.out.println("等待第 ： " + i + " 秒");
			Thread.sleep(1000);
		}
		System.out.println("start");
	}
	
}
