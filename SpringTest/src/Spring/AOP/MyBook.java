package Spring.AOP;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {
	
	public void before1() {
		System.out.println("前置增强。。。");
	}
	
	public void after1() {
		System.out.println("后置增强。。。");
	}
	
	public void arround1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕前。。。。。");
		proceedingJoinPoint.proceed();
		System.out.println("环绕后。。。。。。");
	}

}
