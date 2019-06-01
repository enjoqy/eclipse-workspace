package cn.kgc.transferaccounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 写一个银行类，有如下功能
 * 判断是否注册，没有就注册用户，每个用户都有唯一的id
 * 可以查询余额，进行转账，
 * 也可以进行注销
 * 
 * @author zhuhao
 * @date 2019年3月25日
 */
public class HackerBank {

	public static void main(String[] args) {
		//		List users = new ArrayList<>();
		//		List ids = new ArrayList<>();

		Map<Long, User> accounts = new HashMap(); 

		Scanner input = new Scanner(System.in);

		System.out.println("欢迎来到hk银行，想干点什么吗？\n请选择序号：" + "\n");
		System.out.println("1:查询余额\n2:转账\n3：注册账户\n4:离开");
		System.out.println();

		int a = input.nextInt();

		boolean flag = true;
		while(flag) {
			if(a<1 || a>4) {
				System.out.println("请选择有用的序号");
				System.out.println();
				a = input.nextInt();
				flag = true;
			}else {
				flag = false;
			}
		}

		while(true) {
			switch(a) {
			case 1:   //查询余额
				System.out.println("请输入10位数银行卡号" + "\n");
				long id = input.nextLong();

				if(accounts.size() != 0) {
					//判断是否有这个id
					for(int i=0; i<accounts.size(); i++) {

						User user = accounts.get(id);
						if(user.getId() == id) {
							break;
						}else {
							System.out.println("没有这个id，请重新输入，或者注册用户" + "\n");
							id = input.nextLong();
						}
					}
				}else {
					System.out.println("目前还没有账户，请创建");
					System.out.println();

					System.out.println("请选择有用的序号" + "\n");
					System.out.println("1:查询余额\n2:转账\n3：注册账户\n4:离开" + "\n");
					a = input.nextInt();
					boolean flag1 = true;
					while(flag1) {
						if(a<1 || a>4) {
							System.out.println("请选择有用的序号" + "\n");
							a = input.nextInt();
							flag1 = true;
						}else {
							flag1 = false;
						}
					}

					break;
				}



				User user1 = accounts.get(id);

				System.out.println("你的账户名为： \t" + user1.getName() + "\n 您的账户余额为： \t" + user1.getBalance()  + "\n");

				System.out.println("请选择有用的序号" + "\n");
				System.out.println("1:查询余额\n2:转账\n3：注册账户\n4:离开" + "\n");
				a = input.nextInt();
				boolean flag1 = true;
				while(flag1) {
					if(a<1 || a>4) {
						System.out.println("请选择有用的序号" + "\n");
						a = input.nextInt();
						flag1 = true;
					}else {
						flag1 = false;
					}
				}

				break;




			case 2:   //转账
				System.out.println("请输入自己的10位数银行卡号" + "\n");
				long idzj = input.nextLong();

				//判断是否有这个id
				for(int i1=0; i1<accounts.size(); i1++) {

					User user11 = accounts.get(idzj);
					if(user11.getId() == idzj) {
						break;
					}

				}
				User user12 = accounts.get(idzj);

				System.out.println("请输入您要给哪个卡号转账" + "\n");
				long id2 = input.nextLong();
				//判断是否有这个id
				for(int i=0; i<accounts.size(); i++) {

					User user = accounts.get(id2);
					if(user.getId() == id2) {
						break;
					}
					System.out.println("没有这个id，请重新输入");
					id2 = input.nextLong();
				}

				User user2 = accounts.get(id2);

				System.out.println("请确认您转账的是不是这个这个账户：  id为  ：" + id2 + " 账户名为： " + user2.getName() + "\n");

				//				System.out.println("Y 或  N");

				System.out.println("请输入您要转多少钱" + "\n");
				double money = input.nextLong();

				//				if(money > user11.getBalance()) {
				//					System.out.println("余额不足");
				//				}

				double money1 = user12.getBalance() -  money ;
				user12.setBalance(money1);
				accounts.remove(idzj);
				accounts.put(idzj, user12);

				double money2 = user2.getBalance() +  money ;
				user2.setBalance(money2);
				accounts.remove(id2);
				accounts.put(id2, user2);

				System.out.println("转账成功" + "\n");


				System.out.println("请选择有用的序号");
				System.out.println("1:查询余额\n2:转账\n3：注册账户\n4:离开\n");
				a = input.nextInt();
				boolean flag3 = true;
				while(flag3) {
					if(a<1 || a>4) {
						System.out.println("请选择有用的序号\n");
						a = input.nextInt();
						flag3 = true;
					}else {
						flag3 = false;
					}
				}
				break;





			case 3:  //注册账户
				User user = new User();
				System.out.println("请输入姓名：");
				String name = input.next();
				user.setName(name);
				System.out.println("请输入要存多少钱：");
				double d = input.nextDouble();
				user.setBalance(d);
				user.setId(1);

				System.out.println("系统帮您创建的一个10位数的银行卡号:" + user.getId()  + "\n");

				//个人信息存入map
				accounts.put(user.getId(), user);

				System.out.println("请选择有用的序号");
				System.out.println("1:查询余额\n2:转账\n3：注册账户\n4:离开\n");
				a = input.nextInt();
				boolean flag33 = true;
				while(flag33) {
					if(a<1 || a>4) {
						System.out.println("请选择有用的序号");
						a = input.nextInt();
						flag33 = true;
					}else {
						flag33 = false;
					}
				}
				break;

			case 4:   //离开
				System.out.println("byebye!");
				System.exit(0);
			}

		}
	}

}
