package mzl.jichu;

public class ForTest {

	public static void main(String[] args) {
		ForTest m = new ForTest();

		double  a[]  = {1.1, 1.5, 1.6, 2.1, 3.9, -0.9, -1.1, -0.1};

		for(double b : a) {
			m.print(b);
		}

	}


		public void print(double b) {
			System.out.println("Math.floor ( " + b + " )=" + Math.floor(b) + "\t���� <= �������������ֵ");
			System.out.println("Math.round ( " + b + " )=" + Math.round(b) + "\t��������");
			System.out.println("Math.ceil ( " + b + " )=" + Math.ceil(b)  + "\t���� >= ������������Сֵ");
		}
	

}

