package cn.kgc.mymath;

public class Lyric {
	public static void main(String[] args) {
		String words = "长亭外 古道边 芳草碧连天 晚风拂 柳笛声残 夕阳山外山";
		String[] printWord = new String[100];
		System.out.println(words);
		printWord = words.split(" ");
		System.out.println("格式化后的歌词");
		for (String string : printWord) {
			System.out.println(string);
		}
		
	}
}
