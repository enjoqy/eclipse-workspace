package cn.kgc.demo02;

public class NijieException extends Exception{
	
	private char sex;

	public void set(char c) throws Exception{
		
		if((c == '男')||(c == '女')) {
			sex = c;
		}else {
			throw new Exception("性别必须是男或者女！");
		}
		
	}
	
}
