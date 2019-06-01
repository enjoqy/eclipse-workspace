package com.train.homework;

/**
 * 1块钱1瓶水，3个瓶盖可以换一个瓶水，n块钱最多可以喝多少瓶水
 * @author zhuhao
 * @date 2019年3月5日
 */
public class Sum {

	public static void main(String[] args) {
		int sum=0;
		int cap=0;
		Sum sum1 = new Sum();
		int sum2 = sum1.get(sum, cap, 20);
		System.out.println(sum2);
		
		
	}
	
	public int get(int sum, int cap, int water) {
		cap += water;
		sum += water;
		water = 0;
		if(cap<3) {
			return sum;
		}else {
			return get(sum,cap%3,cap/3);
		}
	}
}
