package cn.kgc.myimplements;

public class Test {
	
	public static void main(String[] args) {
		ShoutAbility ao_shout = new AoShout();
		ShoutAbility zha_shout = new ZhaShout();
		
		Bird bomb = new BombBird(ao_shout);
		Bird split = new SplitBird(zha_shout);
		
		bomb.shout();
		split.shout();
		
		bomb.attack();
		split.attack();
	}
}
