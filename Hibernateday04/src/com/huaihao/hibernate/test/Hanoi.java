package com.huaihao.hibernate.test;

public class Hanoi{
	private static int count = 0;
	public static void move(char src, char des, int n){
		System.out.println("plate:"+ src +" pillar"+"->"+des+" pillar");  //plateÅÌ×Ó pillarÖ§Öù
		count++; 
	}
	public static void hanoiSolver(char src, char via, char des, int n){ 
		if (n==1){ 
			move(src, des, n);
		} else{
			hanoiSolver(src, des, via, n-1);
			move(src, des, n); hanoiSolver(via, src, des, n-1);
		} 
	} 
	public static void main(String[] args) {
		char src = 'A'; //source pillar 
		char des = 'B'; //detination pillar 
		char via = 'V'; //via pillar 
		int n = 3;// the numer of plates 
		hanoiSolver(src, via, des, n); 
		System.out.println("the total number of moves is "+count);
	} 
}

