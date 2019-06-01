package cn.kgc.demo02;

import java.util.Scanner;

/*����Ƕ��ѭ��
 * 2019-3-1
 */
public class MyLoop {
	public static void main(String[] args) {
		String tmp = null;
		do {
			System.out.println("������ѧ��������");
			Scanner scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			int[] arrays = new int[5];
			int sum = 0;
			for(int i=0; i<5; i++) {
				System.out.println("���������Ź����еĵ� " + (i+1 ) + ",�Ź��εĳɼ���");
				arrays[i] = scanner.nextInt();
				sum += arrays[i];
			}
			System.out.print(name + "�����Ź����еĳɼ��ֱ�Ϊ��");
			for (int i : arrays) {
				System.out.print(i + ",");
			}
			System.out.println("  �ܳɼ�Ϊ�� " + sum);
			System.out.println("�Ƿ�Ҫ������ȷ��������\"Y\",�˳�������\"N\".");
			tmp = scanner.next();
		}while(tmp.equals("Y")||tmp.equals("y"));
		System.out.println("������");	
	}
}
