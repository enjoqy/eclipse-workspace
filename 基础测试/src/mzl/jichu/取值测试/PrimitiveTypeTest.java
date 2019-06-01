package mzl.jichu.取值测试;

public class PrimitiveTypeTest extends InstanceCounter {  //Primitive:原始的  Type:类型
	
	private int a = 8;
	
	PrimitiveTypeTest ptt = new PrimitiveTypeTest();
	
	protected int getqz() {
//		return  a;
		return ptt.getCounter();
	}
	
	protected void setqz(int a) {
		this.a=a;

//		return;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		
		
		//Byte
		System.out.println("//Byte");
		System.out.println("基本类型，byte 二进制位数: " + Byte.SIZE);
		System.out.println("包装类java.lang.Byte");
		System.out.println("最小值： BYte.MIN_VALUE= " + Byte.MIN_VALUE);
		System.out.println("最大值： BYte.Max_VALUE= " + Byte.MAX_VALUE);
		System.out.println();

		//Short
		System.out.println("//Short");
		System.out.println("基本类型，Short 二进制位数: " + Short.SIZE);
		System.out.println("包装类java.lang.Short");
		System.out.println("最小值： Short.MIN_VALUE= " + Short.MIN_VALUE);
		System.out.println("最大值：Short.Max_VALUE= " + Short.MAX_VALUE);
		System.out.println();

		//Int
		System.out.println("//Int");
		System.out.println("基本类型，int 二进制位数: " + Integer.SIZE);
		System.out.println("包装类java.lang.Integer");
		System.out.println("最小值： Integer.MIN_VALUE= " + Integer.MIN_VALUE);
		System.out.println("最大值：IntegerMax_VALUE= " + Integer.MAX_VALUE);
		System.out.println();

		//Long
		System.out.println("//Long");
		System.out.println("基本类型，Long 二进制位数: " + Long.SIZE);
		System.out.println("包装类java.lang.Long");
		System.out.println("最小值： Long.MIN_VALUE= " + Long.MIN_VALUE);
		System.out.println("最大值：LongMax_VALUE= " + Long.MAX_VALUE);
		System.out.println();

		//Float
		System.out.println("//Float");
		System.out.println("基本类型，Float 二进制位数: " + Float.SIZE);
		System.out.println("包装类java.lang.Float");
		System.out.println("最小值： Long.MIN_VALUE= " + Float.MIN_VALUE);
		System.out.println("最大值：LongMax_VALUE= " + Float.MAX_VALUE);
		System.out.println();

		//Double
		System.out.println("//Double");
		System.out.println("基本类型，Double 二进制位数: " + Double.SIZE);
		System.out.println("包装类java.lang.Double");
		System.out.println("最小值： Double.MIN_VALUE= " + Double.MIN_VALUE);
		System.out.println("最大值：DoubleMax_VALUE= " + Double.MAX_VALUE);
		System.out.println();

		//Char
		System.out.println("//Char");
		System.out.println("基本类型，Char 二进制位数: " + Character.SIZE);
		System.out.println("包装类java.lang.Character");
		System.out.println("最小值： Character.MIN_VALUE= " + (int)Character.MIN_VALUE);
		System.out.println("最大值：CharacterMax_VALUE= " + (int)Character.MAX_VALUE);
		System.out.println();
	}

}
