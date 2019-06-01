package cn.kgc.arithmetic;

import java.util.Iterator;

/**
 * 冒泡排序
 * 
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。  
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。  
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 
 * @author zhuhao
 * @date 2019年3月17日
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] i = {4,6,2,1,9,0,3,55,33,62,9,99,112,5};
		int[] a = BubbleSort.bubbleSort(i);

		for (int j : a) {
			System.out.print(j + "\t");
		}
	}

	public static int[] bubbleSort(int[] number) {
		int tmp = 0;
		for(int i=0; i<number.length-1; i++) {
			for(int j=0; j<number.length-1-i; j++) {
				if(number[j]>number[j+1]) {
					tmp = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp;
				}
//				System.out.print(number[j] + "\t");
			}
//			System.out.println();
		}
		return number;
	}
}
