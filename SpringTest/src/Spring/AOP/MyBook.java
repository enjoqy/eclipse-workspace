package Spring.AOP;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {
	
	public void before1() {
		System.out.println("ǰ����ǿ������");
	}
	
	public void after1() {
		System.out.println("������ǿ������");
	}
	
	public void arround1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("����ǰ����������");
		proceedingJoinPoint.proceed();
		System.out.println("���ƺ󡣡���������");
	}

}
