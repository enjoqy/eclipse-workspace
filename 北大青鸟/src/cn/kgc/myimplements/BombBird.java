package cn.kgc.myimplements;

//炸弹鸟
public class BombBird extends Bird{

	public BombBird(ShoutAbility shout_ability) {
		super(shout_ability);
	}

	public void attack() {
		System.out.println("炸弹攻击！");
	}
	
	
}
