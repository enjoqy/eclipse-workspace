package cn.kgc.myimplements;

public abstract class Bird {
	
	ShoutAbility shout_ability;  //声明一个借口，鸟叫的方式

	public Bird(ShoutAbility shout_ability) {
		this.shout_ability = shout_ability;
	}
	
	//叫
	public void shout() {
		shout_ability.shout();
	}
	
	//飞
	public void fly() {
		System.out.println("弹射飞。。");
	}
	
	//抽象方法，攻击
	public abstract void attack(); 

}
