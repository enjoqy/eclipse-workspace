package cn.kgc.myannotation;

/**
 * 测试注解annotaticon
 * 
 * @author zhuhao
 * @date 2019年3月19日
 */
@SuppressWarnings(value = { "unchecked", "deprecation", "unused", "path", "fallthrough", "serial", "finally", "all" })
public class DemoAnnotation {
	
	
	
	//一定一个过时的方法
	@Deprecated
	public void test() {
		System.out.println("手动定义，过时的方法");
	}
	
	//

}
