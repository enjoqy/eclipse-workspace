package cn.kgc.mythread;
/**
 * 测试线程之间的通信
 * @author zhuhao
 * @date 2019年3月19日
 */
public class Communication {

	public static void main(String[] args) {
		//共享同一个资源
		SharedData s = new SharedData();
		//消费者线程
		new Consumer(s).start();
		//生产者线程
		new Producer(s).start();
	}
}
