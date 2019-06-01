package cn.kgc.variableparameter;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * 可变参数
 * 
 * @author zhuhao
 * @date 2019年3月14日
 */
public class VariableParameter {
	
	

	private static Logger logger = Logger.getLogger(VariableParameter.class);
	
	public int add(int...args) {
		int sum = 0;
		for(int i=0; i<args.length; i++) {
			sum += args[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		VariableParameter vp = new VariableParameter();
		int a = vp.add(1,2,3,4,5,6);
		logger.debug("a= " + a);
		int b = vp.add(new int[] {1,2,3,4,5,6});
		logger.debug("b= " + b);
		System.out.println(a);
		System.out.println(b);
		
		int a1,b1;
		
		a1 = 1;
		logger.debug("a1="+a1);
		b1 = 0;
		logger.debug("b1="+b1);
		try {
			System.out.println(a1/b1);
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
	}


}
