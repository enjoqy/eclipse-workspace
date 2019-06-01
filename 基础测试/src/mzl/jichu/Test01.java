package mzl.jichu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 {
	
	public static void main(String[] args) {
		
		int a = 2, b=3;
		int k = max(a,b);
		System.out.println(k);
		printGrade(a);
		
		
	}
	
	public static int max(int i, int j) {  //
		int result;
		if(i>j) {
			result = i;
		}else {
			result = j;
		}
		return result;
	}
	
	public static void printGrade(double score) {
		if(score>=90) {
			System.out.println("A");
		}else if(score>=80) {
			System.out.println("B");
		}else {
			System.out.println("C");
		}
	}
}
		
