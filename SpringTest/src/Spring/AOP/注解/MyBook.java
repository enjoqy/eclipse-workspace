package Spring.AOP.ע��;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {
	
	@Before(value="execution(* Spring.AOP.ע��.Book.*(..))")
	public void before1() {
		System.out.println("ǰ����ǿ��������");
	}
	
	@AfterReturning(value="execution(* Spring.AOP.ע��.Book.*(..))")
	public void after1() {
		System.out.println("������ǿ������������");
	}
	
	@Around(value="execution(* Spring.AOP.ע��.Book.*(..))")
	public void arround1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("����ǰ����������");
		proceedingJoinPoint.proceed();
		System.out.println("���ƺ󡣡���������������");
		
	}

}
