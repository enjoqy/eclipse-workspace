package cn.kgc.mythread;
/**
 * 测试同步
 * 
 * @author zhuhao
 * @date 2019年3月19日
 */
public class TestAcountDemo  {
	public static void main(String[] args) {
		TestAcount t = new TestAcount();
		Thread thread1 = new Thread(t);
		Thread thread2 = new Thread(t);
		thread2.setName("00");
		thread1.setName("zhangsan");
		thread1.start();
		thread2.start();
	}
}
