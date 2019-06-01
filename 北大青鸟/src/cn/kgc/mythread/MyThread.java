package cn.kgc.mythread;

import org.junit.Test;

/**
 * 测试线程，用实现接口
 * 设置了线程的优先级
 * setPriority(1),取值范围是1-10的整数，其他的数值会报错
 * 
 * @author zhuhao
 * @date 2019年3月19日
 */
public class MyThread implements Runnable{
	
	private int count = 0;
	
	public void run() {
		while(count < 10) {
			count++;
			System.out.println(Thread.currentThread().getName() + " " + count);
		}
	}
	
	//高优先级的线程比低优先级的线程有更高的几率得到执行，实际上这和操作系统及虚拟机版本相关，
	//有可能即使设置了线程的优先级也不会产生任何作用。
	public static void main(String[] args) {
		Thread thread1  = new Thread(new MyThread());
		thread1.setPriority(1);
		Thread thread2 = new Thread(new MyThread());
		thread2.setPriority(5);
		Thread thread3 = new Thread(new MyThread());
		thread3.setPriority(10);
		thread1.start();
		thread2.start();
		thread3.start();
	}

	
	
	

}
