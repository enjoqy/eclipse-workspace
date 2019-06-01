package cn.kgc.transferaccounts;

import java.util.UUID;


public final class CreateID {

	private static long ID;
	 UUID uuid = UUID.randomUUID();
	
	
	public static long getID() {
		 CreateID cid = new  CreateID();
		return cid.replace(UUID.randomUUID());
	}
	


	private long  replace(UUID uuid) {  //将uuid中的前10位数字提取，并返回long
		String str =  uuid.toString().replace("-", "");
		StringBuilder str1 = new StringBuilder();
		for (char c : str.toCharArray()) {
			if(Character.isDigit(c)) {
				str1.append(c);
			}
		}
		String str2 = str1.toString().substring(0,10);
		long l = Long.parseLong(str2);
		return l;
	}
	
	public static void main(String[] args) {
		System.out.println(CreateID.getID());
		System.out.println(CreateID.getID());
		System.out.println(CreateID.getID());
	}

	

}
