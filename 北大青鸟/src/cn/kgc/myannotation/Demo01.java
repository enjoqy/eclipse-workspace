package cn.kgc.myannotation;
/**
 * 调用一个自定义的过时的方法，将会有横线提示
 * @author zhuhao
 * @date 2019年3月19日
 */
public class Demo01 {
	
	public static void main(String[] args) {
		DemoAnnotation da = new DemoAnnotation();
		da.test();
	}

}
