package cn.kgc.myenum;

/**
 * 查看日程安排，测试枚举类型
 *
 * @author zhuhao
 * @date   2019年3月7日
 */
public class DemoEnum {

	public DemoEnum() {
		
	}
	
	public enum Week{  //枚举类
		MON,TUE,WED,THU,FRI,SAT,SUN
	}

	
	public void daWhat(Week day) {
		switch(day) {
		case MON:
		case TUE:
		case WED:
		case THU:
		case FRI:
			System.out.println("工作日，要努力写代码！");
			break;
		case SAT:
			System.out.println("星期六，休息！看电影！");
			break;
		case SUN:
			System.out.println("星期日，休息！打篮球！");
			break;
		default:
			System.out.println("地球上一个星期就7天，别想了，，把她当成一个5岁的小女孩，");
			System.out.println("战术上藐视，战略上重视！");
		}
	}
	
	public static void main(String[] args) {
		DemoEnum de = new DemoEnum();
		de.daWhat(Week.WED);
	}
}
