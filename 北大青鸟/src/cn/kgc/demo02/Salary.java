package cn.kgc.demo02;

import java.util.Scanner;
/*����Ա�����ʡ�
 * 2019-3-1
*/

public class Salary {
	public static void main(String[] args) {
		int salary=0;
		System.out.println("������������ʣ�");
		Scanner scanner = new Scanner(System.in);
		salary = scanner.nextInt();
		System.out.println("��Ա���Ļ�������Ϊ�� " + salary);
		System.out.println(salary*0.4);
		System.out.println(salary*0.25);
		System.out.println(salary*1.65);
	}

}
