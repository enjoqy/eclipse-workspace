package cn.kgc.arithmetic;

/**
 * 使用线程排序的大佬，流弊
 * 
 * @author zhuhao
 * @date 2019年3月16日
 */
public class ThreadArraySort implements Runnable{
	
	private String num;
	
	public ThreadArraySort(int num) {
		this.num = num + "";
	}


	public void run() {
		try {
			Thread.sleep(Integer.parseInt(num));
			System.out.print(num + "\t");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int[] sums = {11,2,2,1,1,11,2,3,3,4,4,3333,444,55}; 
		for(int i=0; i<sums.length; i++) {
			ThreadArraySort d = new ThreadArraySort(sums[i]);
			new Thread(d).start();
		}
	}
}
