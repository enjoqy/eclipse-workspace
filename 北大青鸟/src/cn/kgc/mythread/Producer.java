package cn.kgc.mythread;
/**
 * 生产者线程类
 * @author zhuhao
 * @date 2019年3月19日
 */
public class Producer extends Thread{

	private SharedData s;

	public Producer(SharedData s) {
		this.s = s;
	}

	public void run() {

		for (int i = 0; i < 5; i++) {

			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			s.put();
		}
		
	}

}
