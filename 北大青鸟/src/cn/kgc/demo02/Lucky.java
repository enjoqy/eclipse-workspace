package cn.kgc.demo02;

import java.util.Scanner;
/*��ȡ���̵����룬��û�Ա����
 * �������
 *2019-3-1
 *
 */
public class Lucky {

	public static void main(String[] args) {
		
		String custNO1;
		System.out.println("������λ��Ա����");
		Scanner input = new Scanner(System.in);
		
		while(true) {
			custNO1 = input.nextLine();
			if(custNO1.length() != 4) {
				System.out.println("��������λ���֣�");
			}else {
				int custNO = 0;
				try {
					custNO =  Integer.parseInt(custNO1);
				} catch (Exception e) {
					System.out.println("����������");
//					e.printStackTrace();
				}
				System.out.println("��Ա�����ǣ� " + custNO);
				int gw = custNO % 10;
				int sw = custNO /10 %10;
				int bw = custNO /100 %10;
				int qw = custNO /1000 %10;
				//		System.out.println(" gewei" + gw+ sw + bw + qw );
				int sum = gw + sw + bw + qw;
				System.out.println("��Ա���ţ� " + custNO + " ��λ֮�� " + sum);
				if(sum >= 30) {
					System.out.println("��Ա���ţ� " + custNO + " �Ļ�Ա�����н��ˣ���Ʒ�ǰµ�һ����");
				}else {
					System.out.println("��Ա���ţ� " + custNO + " �Ļ�Ա�����ź���������֮��ʧ֮���ۣ�");
				}
			}
		}
	}
	
	
	
}
