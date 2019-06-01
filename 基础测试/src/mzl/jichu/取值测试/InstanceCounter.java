package mzl.jichu.取值测试;

public class InstanceCounter{  //instance:例子，实例;counter:计数器，柜台
	
	private static int numInstances = 0;
	
	protected  int getCounter() {
		return numInstances;
	}

	protected  void addInstance() {
		numInstances += 1;
	}
	

	
//	/**public static void main(String[] args) {
//		
//		InstanceCounter ic = new InstanceCounter();
//		System.out.println("Starting with " + ic.getCounter() + " Instances");
//		
//		for(int i=0; i<500; i++) {
//			ic.addInstance();
//		}
//		
//		System.out.println("Created " + ic.getCounter() + " Instances");
//		*/
//		PrimitiveTypeTest ptt = new PrimitiveTypeTest();
//		System.out.println(ptt.getqz());
//		ptt.setqz(110);
//		
//		System.out.println(ptt.getqz());
		
	}
	
	
