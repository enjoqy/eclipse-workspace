package Spring.AOP.注解;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {
	
	@Before(value="execution(* Spring.AOP.注解.Book.*(..))")
	public void before1() {
		System.out.println("前置增强。。。。");
	}
	
	@AfterReturning(value="execution(* Spring.AOP.注解.Book.*(..))")
	public void after1() {
		System.out.println("后置增强。。。。。。");
	}
	
	@Around(value="execution(* Spring.AOP.注解.Book.*(..))")
	public void arround1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕前。。。。。");
		proceedingJoinPoint.proceed();
		System.out.println("环绕后。。。。。。。。。");
		
	}

}
