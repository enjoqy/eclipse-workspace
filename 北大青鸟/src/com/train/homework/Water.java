package com.train.homework;


import java.util.Scanner;

public class Water {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入瓶数：");
		int water = scanner.nextInt();
		int number=0;
		int cap=0;
		Water w=new Water();
		int w2 = w.water(number, cap, water);
		System.out.println("能买"+ w2+"瓶可樂！");
	}

	public int water(int number,int cap,int water) {
		cap+=water;
		number+=water;
		water=0;
		if (cap<3) {
			return number;
		}else {
			return water(number,cap%3,cap/3);
		}
	}
}