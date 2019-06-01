package kgc.orderingmeals;

import java.util.Scanner;

/*吃货联盟订餐系统
 */
public class OrderingMeals {  //订餐

	public static void main(String[] args) {

		String[] names = new String[4];  //订餐人的姓名
		String[] dishMegs = new String[4];  //所选信息，包括菜品和份数
		int[] times = new int[4];  //送餐时间
		String[] addresses = new String[4];  //送餐地址
		int[] states = new int[4];  //订单状态：0表示已预订，1表示已完成
		double[] sumPrices = new double[4];  //订单总金额

		String[] dishNames = new String[] {"红烧肉","可乐鸡翅","家常菜"};  //菜品名
		double[] prices = new double[] {30,50,20};  //菜的价格
		int[] praiseNums = new int[3];  //点赞数

		Scanner input = new Scanner(System.in);
		int num = -1;  //用户输入0返回主菜单，否则退出系统
		boolean isExit = false;  //标志用户是否退出系统，true代表退出

		System.out.println("欢迎使用\"吃货联盟订餐系统\" ");
		do {
			System.out.println("********************************");
			System.out.println("1、我要订餐\r2、查看餐袋\r3、签收订单\r4、删除订单\r5、我要点赞\r6、退出系统");
			System.out.println("********************************");
			System.out.println("请根据编号选择服务：");

			int choose = input.nextInt();

			switch(choose) {
			case 1:
				System.out.println("******我要订餐*******");

				boolean isAdd = false;  //记录是否可以订餐
				for(int i=0; i<names.length; i++) {
					if(names[i] == null) {
						isAdd = true;
						System.out.println("请输入订餐人的姓名：");
						String name = input.next();

						//显示供选择的菜品信息
						System.out.println("序号\t菜名\t单价\t点赞数");
						for(int j=0; j<dishNames.length; j++) {
							String praiseNum = (praiseNums[i])>0 ? praiseNums[i] + "赞" : "0";  //判断，输出菜品对应的点赞数
							System.out.println((j+1) + "\t" + dishNames[j] + "\t" + prices[j] + "\t" + praiseNum);
						}

						//用户点菜
						System.out.println("请选择您要点的菜品编号：");
						int chooseDish = input.nextInt();
						System.out.println("请选择您要点的份数：");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish -1] + " " + number + "份";
						double sumPrice = prices[chooseDish -1] * number;
						//餐费满50，免送餐费5元
						double deliCharge = (sumPrice >= 50)?0:5;  //delivery charge 送餐费

						//送餐时间
						System.out.println("请输入送餐时间，（送餐时间是10点到20点之前整点送餐）：");
						int time = input.nextInt();
						while(time <10 || time >20) {
							System.out.println("您输入有误，请输入10~20之间的整数");
							time = input.nextInt();
						}
						
						//送餐地址
						System.out.println("请输入送餐地址：");
						String address = input.next();
						
						//无需添加状态，默认是0，即已预订状态
						System.out.println("您已订餐成功！");
						System.out.println("您订的是：" + dishMeg);
						System.out.println("送餐时间是： " + time + " 点");
						System.out.println("送餐地址是：" + address);
						System.out.println("餐费： " + sumPrice + "元，送餐费：" + deliCharge + 
								"元，总计：" + (sumPrice + deliCharge) + "元" );
						
						//添加数据
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice + deliCharge;  //总餐费
						break;
					}
					if(isAdd) {
						System.out.println("对不起，您的餐袋已满！");
					}
					break;
				}

				break;
			case 2:
				System.out.println("******查看餐袋*******");
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t总金额\t订单状态");
				for(int i=0; i<names.length; i++) {
					if(names[i] != null) {
						String state = (states[i] == 0)?"已预订":"已完成";
						String date = times[i] + "点";
						double sumPrice = sumPrices[i];
						System.out.println((i+1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + 
								date + "\t" + addresses[i] + "\t" + sumPrice + "\t" + state);
					}
				}
				break;
			case 3:
				System.out.println("******签收订单*******");
				break;
			case 4:
				System.out.println("******删除订单*******");
				break;
			case 5:
				System.out.println("******我要点赞*******");
				break;
			case 6:
				System.out.println("******退出系统******");
				break;
			default:
				isExit = true;
				break;
			}

			if(!isExit) {
				System.out.println("输入0返回：");
				num = input.nextInt();
			}else {
				break;
			}

		}while(num == 0);

	}

}
