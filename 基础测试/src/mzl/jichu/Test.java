package mzl.jichu;

public class Test {
	public static void main(String[] args) {

		Integer i1 = 128; //自动装箱
		Integer i2 = Integer.valueOf(128);

		int m1 = i1;  //自动拆箱
		int m2 = i2.intValue();
		
		Character ch = 'a';
		Character ch1 = new Character('b');

		System.out.println(i2);

		Integer j1 = 100;
		Integer j2 = 100;

		if(j1 == j2) {  //java会对 -128~127 之间的整数进行缓存，所以定义的两个变量初始值位于-128~127 之间时，两个变量使用了同一个地址
			             // 当两个Integer变量的数值超出 -128~127 范围时，变量使用了不同的地址
			System.out.println("true  \"df\"    ");
		}else{
			System.out.println("false  \"df\" ");
		}
	}

}
