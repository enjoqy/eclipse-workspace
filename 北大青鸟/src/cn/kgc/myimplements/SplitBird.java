package cn.kgc.myimplements;

public class SplitBird extends Bird {

	public SplitBird(ShoutAbility shout_ability) {
		super(shout_ability);
	}

	@Override
	public void attack() {
		System.out.println("分裂攻击！");
	}

}
