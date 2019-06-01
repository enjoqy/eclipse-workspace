package cn.kgc.mythread;
/**
 * 消费者线程类
 * @author zhuhao
 * @date 2019年3月19日
 */
public class Consumer extends Thread{
	
	private SharedData s;
	
	int i = 0;

	public Consumer(SharedData s) {
		this.s = s;
	}
	
	public void run() {
		
		do {
			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			s.get();
		} while (i<5);
		
	}
	
}
