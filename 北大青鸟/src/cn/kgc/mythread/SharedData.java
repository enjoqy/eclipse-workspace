package cn.kgc.mythread;
/**
 * 这个是生产工厂
 * @author zhuhao
 * @date 2019年3月19日
 */
public class SharedData {
	
	private boolean isProduced = false;
	
	public synchronized void put() {
		
		if(isProduced) {
			try {
				System.out.println("消费者还没消费，停止生产！");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		isProduced = true;
		notify();
		System.out.println("生产了产品,通知消费者消费");
		
	}
	
	public synchronized void get() {
		
		if(!isProduced) {
			
			try {
				System.out.println("生产者还没有生产，停止消费");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		isProduced = false;
		notify();
		System.out.println("消费者消费了产品，通知生产者生产");
	}
}
