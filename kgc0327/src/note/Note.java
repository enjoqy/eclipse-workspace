package note;

/**
 * javacore0218：
 * 		eclipse的使用 （HelloEclipse.java）
 * javacore0219：
 * 		变量（Demo02Var.java）、常量（Demo03Final.java）、注释（Demo01Annotation.java）
 * javacore0220:
 * 		数据类型（Demo01DataType.java）、运算符（Demo02Operator.java）
 * javacore0221:
 * 		if...else...（Demo01If.java）、switch...case...（Demo02Switch.java）
 * javacore0222:
 * 		for（Demo01For.java）、while（Demo02While.java）、数组的基本使用（Demo03Array.java）
 * javacore0225:
 * 		jar包的使用（Demo01Jar.java）
 * javacore0226:
 * 		二维数组（Demo01DoubleArray.java）
 * javacore0227:
 * 		类和对象（Demo01ClassAndObject.java）、抽象和封装（Demo02Encapsulation.java）、构造方法（Demo03Constructor.java）
 * javacore0228:
 * 		权限修饰符（Demo01PermissionModifier.java）
 * javacore0301:
 * 		包的使用（Demo01Package.java）
 * javacore0304:
 * 		继承的基本使用、super关键字、this关键字、重载、重写（Demo01Extend.java）
 * javacore0305:
 * 		继承父类引用指向子类对象、final关键字（Demo01Final.java）、static关键字（Demo02Static.java）
 * javacore0306:
 * 		抽象类（Demo01Abstract.java）、Object类（Demo02Object.java）
 * javacore0307:
 * 		值传递和引用传递（Demo01Transmit.java）、代码块（Demo02CodeBlock.java）、类成员的执行顺序（Demo03ExecutionSequence.java）
 * 
 */

/**
 * Eclipse入门
 * 1.相关配置
 * 		1.配置默认字符编码：/Window/Preferences/General/Workspace  --> UTF-8
 * 		2.配置JDK：/Window/Preferences/Java/Installed JREs  --> 添加JDK1.8
 * 		3.代码助手：/Window/Preferences/Java/Editor/Content Assist
 * 
 * 2.常用快捷键
 * 		代码助手:	 Alt+/
 *		快速修正：Ctrl+1
 *		
 *		快速Outline：Ctrl+O
 *		
 *		删除行：Ctrl+D
 *		在当前行上插入一行：Ctrl+Shift+Enter
 *		在当前行下插入一行： Shift+Enter
 *		上下移动选中的行：Alt+Up/Down
 *		上下复制一行：Ctrl+Alt+Up/Down
 *		
 *		组织导入(导包)：Ctrl+Shift+O
 *		根据对象生成变量：Shift+Alt+L
 *
 *		代码转大写：Ctrl+Shift+X
 *		代码转小写：Ctrl+Shift+Y
 *
 *		快速替换变量名：Alt+Shift+r
 *
 *		全文查找：Ctrl+h
 * 
 * @author junki
 * @date 2019年2月18日
 */

/**
 * 常量：
 * 1.只能赋值一次 final
 * 2.内存中固定不变的空间
 * 3.所有单词大写，多个单词下划线分割
 * 
 * @author junki
 * @date 2019年2月19日
 */

/**
 * 变量定义：
 * 1.先声明后赋值
 * 2.定义：声明+赋值
 * 
 * 变量分类：
 * 1.静态变量：类的内部，方法的外部
 * 2.成员变量：类的内部，方法的外部
 * 3.局部变量：方法内部，语句块内部
 * 
 * 作用域：生存空间，势力范围，通过一对大括号区分
 * 
 * @author junki
 * @date 2019年2月19日
 */

/**
 * 1.注释
 * 		1.文档注释： /**内容 * /
 * 		2.单行注释：//内容
 * 		3.多行注释：/* 内容* /
 * 
 * @author junki
 * @date 2019年2月19日
 */

/**
 * 数据类型
 * 		1.基本数据类型(8种)
 * 			1.byte		1字节
 * 			2.short		2字节
 * 			3.int		4字节
 * 			4.long		8字节
 * 			5.float		4字节
 * 			6.double	8字节
 * 			7.char		2字节
 * 			8.boolean	"1字节"
 * 			
 * 			数据类型转换
 * 				1.自动类型转换
 * 					byte->short->int->long->float->double
 * 					char->int		
 * 
 * 				2.强制类型转换
 * 					a = (int)b; 使用强转符号(数据类型)
 * 			
 * 		2.引用数据类型
 * 			1.类		Class：String
 * 			2.枚举	Enum
 * 			3.接口	interface
 * 			4.注解	@interface
 * 			5.数组	Array
 * 
 * java中的编码采用的就是unicode编码，源文件使用的是utf-8编码，jvm虚拟机找的.class编译文件使用的是utf-16编码格式。
 * java中给char字符的解释是十六位，双字节，也就是按照补码的方式寻求取值范围，就是2^16 - 1，65535
 * 0-255说的是ascill编码格式，一些常用的英文以及符号都在0 - 255范围之内放着，其余位置并没有存放东西，所以就有了0 - 255取值范围的说法，
 * 
 * int 97 强制转为char char中97对应的符号是a
 * 
 * @author junki
 * @date 2019年2月20日
 */

/**
 * switch...case...
 * 
 * 可用数据类型：byte short int char String Enum
 * 不可用数据类型：long float double boolean
 * 
 * for循环的三要素
 * 1.变量的定义
 * 2.循环入口条件
 * 3.变量重新赋值
 * 最佳实践：当循环次数可知的时候
 *
 * break和continue
 * break：跳出整个循环，一次只跳出一层循环
 * continue：执行下次循环
 * return 语句会终止函数的执行并返回函数的值
 * 
 * do...while...
 * 1.先执行循环体，再判断入口条件
 * 2.最少执行1次，最多执行无限次
 * 最佳实践：执行次数不可知，先执行后判断
 * 
 * while
 * 1.先判断入口条件，再执行循环体
 * 2.最少执行0次，最多执行无限次
 * 最佳实践：执行次数不可知，先判断后执行
 * 
 * @author junki
 * @date 2019年2月21日
 */

/**
 * 	类和对象
 * 
 * 	类：类是对象的抽象，是对象的模板，描述了对象的状态和行为(属性和方法)。“物以类聚”。
 * 	对象：对象是类的具体实现，是类的实例，有着具体的状态和行为(属性和方法)。“万物皆对象”。
 * 	
 * 	面向对象的四大特性：封装、继承、多态、抽象
 * 
 * 	类的具体使用：
 * 		1.定义：
 * 			1.创建一个类：java的8种基本数据类型不能满足开发需要，自定义一些复杂的数据类型。
 * 			2.定义类属性：成员变量
 * 			3.定义类方法：成员方法
 * 		2.使用new关键字创建对象
 * 			类名 变量名 = new 类名();
 * 
 * 	面向过程编程：以机器可以理解的方式去编写代码；算法+数据结构=函数
 * 	面向对象编程：以人类可以理解的方式去编写代码；属性+方法=对象
 * 
 * 抽象：针对现实世界的归纳总结，符合人类的思维习惯，可以认为是一种印象
 * 抽象三步走：	
 * 			1.找种类，根据现实中的事物进行分类，找出它的种类
 * 			2.找属性，对象所拥有的共同特征
 * 			3.找方法，对象所拥有的共同行为
 *
 * 
 * 封装：是一种信息隐藏技术，隐藏属性和方法，不希望属性和方法抛头露面，把属性和方法包裹在对象的内部，通过对象来访问
 * 封装的原则：
 * 			1.所有的属性都是私有的
 * 			2.对外提供getter和setter方法(对属性进行读写操作)
 * 				getter()  读属性操作
 * 				setter()  写属性操作
 * 			3.属性和方法的权限控制
 * 				public protected default/friendly private
 * 
 * @author junki
 * @date 2019年2月27日
 */

/**
 * 	普通方法：
 * 		1.定义：封装一个完成特定功能的代码块
 * 		2.格式：
 * 				权限修饰符  [其他修饰符]  返回值类型  方法名(参数列表)  {
 * 					//如果返回值不为void
 * 					return 返回值;
 * 				}
 * 				
 * 				*参数列表：数据类型 变量名,数据类型 变量名
 * 
 * 	构造方法：
 * 		1.定义：在创建对象的同时给对象赋初始值
 * 		2.注意事项：
 * 			1.构造方法没有返回值，方法名和类名相同，一般用public修饰
 * 			2.当我们不自定义构造方法时，java默认提供无参构造方法
 * 			3.当我们自定义了任意构造方法，java不在提供无参构造方法
 * 			4.构造方法可以“重载”
 * 
 * @author junki
 * @date 2019年3月1日
 */

/**
 * 四种权限修饰符：
 * 		定义：
 * 			规定被修饰者的被访问权限。
 * 			可以修饰类、属性、方法			
 * 		分类：
 * 			1.public：可以在本项目中访问
 * 			2.protected：可以本类、本包子类、他包子类中使用
 * 			3.default：可以在本类、本包子类中使用
 * 			4.private：只能在本类中使用
 * 
 * @author junki
 * @date 2019年2月28日
 */

/**
 * 	包的使用：
 * 		1.定义：为了更好地组织类，Java 提供了包机制，用于区别类名的命名空间。
 * 		2.注意事项：
 * 			1.包的命名规则：通常是顶级域名的倒写；公司域名：www.kgc.com 包结构：com.kgc.项目名.模块名
 * 			2.自定义包名，不能以java开头，例如：java.train
 * 			2.声明包：使用关键字package；除了注释和空行以外的第一条java代码。
 * 			3.导入包：使用关键字import；快捷键：ctrl+shift+o
 * 				1.导入Scanner类：import java.util.*; 或者 import java.util.Scanner;
 * 				2.java.lang包下的所有的类，使用时不需要导包。
 * 				3.方法的静态导入：将一个类中的静态方法导入为本类的静态方法；例如：import static java.util.Arrays.*;
 * 
 * @author junki
 * @date 2019年3月1日
 */

/**
 * 		工具类的使用：
 * 			1.类名用final修饰，不允许继承
 * 			2.无参构造用private修饰，不允许创建对象
 * 			3.所有工具方法都要用static修饰
 * 
 * @author junki
 * @date 2019年3月5日
 */

/**
 * 继承(is-a)
 * 		1.定义：继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。
 * 		2.关键字：extends
 * 		3.注意事项：
 * 			1.子类无法继承父类私有(private)的属性和方法。
 * 			2.在调用子类构造方法之前会默认调用父类的无参构造。
 * 			3.子类可以用自己的方式实现父类的方法(重写)。
 * 			4.Java 的继承是单继承，但是可以多重继承。
 * 			5.被final修饰的类，不可被继承。
 * 		4.super关键字
 * 			1.定义：指代父类的对象
 * 			2.使用：
 * 				1.super(); 调用父类的无参构造，只能在子类的构造方法内调用，且只能写在第一行。
 * 				2.super.属性;super.方法; 调用父类的属性和方法。
 * 		5.this关键字
 * 			1.定义：指代本类的对象	
 * 			2.使用：
 * 				1.this(); 调用本类的无参构造，只能在本类的构造方法中调用，且只能写在第一行。	
 * 				2.this.属性;this.方法; 调用本类的属性和方法。
 * 		6.重载：
 * 			1.定义：
 * 				1.发生在本类中
 * 				2.方法名必须相同
 * 				3.参数列表必须不同(参数个数、类型、顺序)
 * 				4.与返回值无关
 * 				5.与权限修饰符无关
 * 			2.编译时多态
 * 
 * 		7.重写：
 * 			1.定义：
 * 				1.发生在父子类中
 * 				2.方法名必须相同
 * 				3.参数列表必须相同(参数个数、类型、顺序)
 * 				4.返回值类型必须相同
 * 				5.子类方法的权限修饰符的权限范围不能小于父类权限修饰符
 * 				6.子类方法抛出的异常不能大于父类方法抛出的异常
 * 			3.运行时多态
 * 				
 * @author junki
 * @date 2019年3月4日
 */

/**
 * 	父类引用指向子类对象：
 * 			1.是一种多态的体现。
 * 			2.只能使用父类中定义过的方法和变量。
 * 			3.子类重写了父类的方法，执行子类重写的方法。
 * 
 * @author junki
 * @date 2019年3月5日
 */

/**
 * final关键字：
 * 		1.修饰类：这个类不可以被继承
 * 		2.修饰变量：即为常量
 * 		3.修饰方法：该方法不能被重写
 * 		4.修饰方法的形参：方法的形参在赋值之后不能被改变
 * 
 * @author junki
 * @date 2019年3月5日
 */

/**
 * 	static关键字；
 * 		1.修饰类：只能修饰内部静态类
 * 		2.修饰变量：即为类变量，使用方法：类名.变量名
 * 		3.修饰方法：即为类方法，使用方法：类名.方法名()
 * 		4.方法的静态导入：将目标类中的静态方法导入为本类的静态方法。		
 * 
 * @author junki
 * @date 2019年3月5日
 */

/*
 * 	内部类：
 * 		1.可以被public修饰
 * 		2.编译时，内部类会生成单独的class文件，命名格式：外部类名&内部类名.class
 * 		3.如果要在静态方法中调用，必须用static修饰，即为静态内部类。
 * 		
 */

/**
 * 	抽象类
 * 		1.定义：类是一种抽象，抽象类比类更抽象。
 * 		2.特征：
 * 			1.用abstract关键字修饰
 * 			2.包含属性、方法(抽象方法、具体方法)
 * 			3.抽象类不能被final修饰
 * 			4.抽象类不能创建对象，只能使用子类创建对象
 * 			5.继承抽象类的两种情况：
 * 				1.子类重写所有父类抽象方法
 * 				2.子类不重写或部分重写父类抽象方法，子类也是抽象类
 * 			6.常见问题：
 * 				1.子类必须重写所有父类抽象方法	false
 * 				2.抽象类中一定有抽象方法	false
 * 				3.抽象方法一定在抽象类中	false
 * 				4.有抽象方法的类一定是抽象类	true
 * 
 * 		3.抽象方法：
 * 			1.用abstract关键字修饰
 * 			2.不能有方法实现(不能有{})
 * 			3.不能用private修饰
 * 			4.不能被static修饰
 * 			5.不能被final修饰，形参可以被final修饰
 * 		
 * @author junki
 * @date 2019年3月6日
 */

/**
 * 	Object类：
 * 		1.简介：
 * 			是类层次结构的根类。每个类都使用 Object作为超类。所有对象（包括数组）都实现这个类的方法。 
 * 		2.常用方法：
 * 			1.toString()：类的全限定名@对象哈希码的无符号十六进制
 * 			2.getClass()：获得对象的class对象，class中有getName()方法，可以获取类的全限定名
 * 			3.hashCode()：获取对象的哈希码
 * 			4.equals()：若类没有重写，则比较对象的地址，若重写了该方法，则比较内容
 * 			5.clone()：类必须重写该方法，用于克隆一个对象。
 * 			6.finalize()：类必须重写该方法，对象被gc回收时，自动调用该方法
 * 
 * @author junki
 * @date 2019年3月6日
 */

/**
 * 	值传递和引用传递
 * 		1.值传递：在调用方法的时候，实参将本身值的备份传递给形参。
 * 		2.引用传递：在调用函数时将实际参数的地址传递到函数中，那么在函数中对参数所进行的修改，将影响到实际参数。
 * 		3.java中只有值传递：
 * 			1.按值传递：传递时，拷贝的是值
 * 			2.按引用传递：传递时，拷贝的是引用地址
 * 
 * @author junki
 * @date 2019年3月7日
 */

/**
 * 	代码块
 * 		1.普通代码块，对象创建的时候执行	
 * 		2.静态代码块，类被加载的时候，会自动执行
 * 
 * @author junki
 * @date 2019年3月7日
 */

/**
 * 	类中成员的执行顺序：
 * 		父类静态块=父类静态属性>子类静态块=子类静态属性>
 * 		父类普通块=父类普通属性>父类构造>子类普通块=子类普通属性>子类构造	
 * 
 * @author junki
 * @date 2019年3月7日
 */

/**
 * 	接口
 * 		1.类是对象的抽象，抽象类是类的抽象，接口是抽象的抽象类。
 * 		2.接口可以表示一种规范；也可以表示一种能力。
 * 		3.使用：定义的关键字 interface，实现的关键字 implements。
 * 		4.注意事项：
 * 			1.接口的修饰符只能是public abstract，可以省略不写。
 * 			2.常量：只能用public static final修饰，常量必须初始化赋值，可以省略不写。
 * 			3.抽象方法：只能用public abstract修饰，不能有方法实现，可以省略不写。
 * 			4.jdk1.8+：接口中可以有默认方法和静态方法
 * 				1.方法的默认实现：关键字default修饰，子类实现父接口，如果不重写，即使用改默认实现。
 * 				2.静态方法：关键字static修饰，可以用接口名直接调用，或者在默认方法实现中调用。
 * 			5.除非实现接口的类是抽象类，否则必须实现所有抽象方法。
 * 			6.一个类只能继承一个父类，但是可以实现多个接口。
 * 		5.接口的继承：
 * 			1.接口的继承是多继承。一个接口继承多个接口。
 * 			2.关键字extends，多个父接口用逗号分隔。
 * 		6.接口的分类：
 * 			1.普通接口：满足接口的基本定义条件即可。
 * 			2.标识接口：只有方法名称，没有具体属性和方法，仅有标识作用，标识这个类有某种能力。
 * 			3.函数式接口：只有一个抽象方法，可以有多个默认实现方法、静态方法。用于函数式编程。可以用注解@FunctionalInterface做校验。
 * 			4.常量接口：接口中只有常量，没有抽象方法，类实现改接口可以使用规定好的常量。
 * 
 * 		5.问题：
 * 			1.接口中的属性都是常量	true
 * 			2.接口中的方法都是抽象方法	false
 * 
 * 
 * 
 * @author junki
 * @date 2019年3月11日
 */

/**
 * 	多态：
 * 		1.定义：多种行为多种状态，同一个父类或接口，使用不同子类或实现类，执行不同的操作。
 * 		2.原则：父类或父接口的引用指向子类或实现类的对象。
 * 		3.向上转型：子类对象转为父类对象
 * 			1.子类引用指向子类对象 -> 父类引用指向子类对象	可以转换
 * 		4.向下转型：父类对象转为子类对象
 * 			1.父类引用指向子类对象 -> 子类引用指向子类对象	可以转换
 * 			2.父类引用指向父类对象 -> 子类引用指向父类对象	运行报错
 * 		5.判断是否可以转型，可以使用关键字instanceof判断
 * 			对象名 instanceof 类名。
 * 			判断关键字左边的对象是否可以转为关键字右边的类型。
 * 
 * @author junki
 * @date 2019年3月12日
 */

/**
 * 	异常
 * 		1.定义：异常是指在程序的运行过程中所发生的不正常的事件，它会中断正在运行的程序
 * 		2.分类：
 * 			1.检查性异常（编译时异常），checked exception：不处理或抛出，程序无法通过编译。
 * 				ClassNotFoundException
 * 				FileNotFoundException
 * 				IOException
 * 
 * 			2.非检查性异常（运行时异常），unchecked exception，runtime exception：不处理或抛出，程序可以通过编译，但是运行时可能发生异常。
 * 				InputMismatchException
 * 				ArithmeticException
 * 				NullPointerException
 * 				ArrayIndexOutOfBoundsException
 * 				NumberFormatException
 * 			3.Error 错误
 * 			4.throw 用户自定义异常
 * 	异常的处理机制：
 * 		try-catch-finally
 * 			1.使用：
 * 				try：修饰可能产生异常的代码块
 * 				catch：捕获代码块产生的异常
 * 				finally：无论是否产生异常都会执行
 * 			2.注意事项：
 * 				try不能省略，catch和finally可选其一。
 * 			
 * @author junki
 * @date 2019年3月14日
 */

/**
 * 	自定义异常：
 * 		1.继承Exception类（建议）
 * 		2.继承Throwable类
 * 
 * @author junki
 * @date 2019年3月15日
 */

/**
 * ArrayList
 * 		1.特征：
 * 			1.底层实现是数组、数据结构线性表(连续的元素、连续的存储空间、有首有尾、相互连接)
 * 			2.可变长的数组：
 * 				jdk1.8之前，默认容量是10；jdk1.8之后，默认容量是0
 * 				扩容后容量为当前容量的1.5倍（扩容50%）
 * 			3.有序、不唯一、可为null、有索引（会越界）
 * 			4.是不同步的、单线程的、不安全的
 * 				如果要安全的list：
 * 					List list = Collections.synchronizedList(new ArrayList(...)); 
 * 			5.查询快、插入删除慢。
 * 
 * 		2.常用方法：
 * 			1.add(E e) 添加元素
 * 			2.add(int index, E element) 在指定索引出添加元素
 * 			3.addAll(Collection<? extends E> c) 添加集合中的所有元素
 * 			4.clear() 清空集合
 * 			5.contains(Object o) 判断是否存在指定元素
 * 			6.get(int index) 获取指定索引的元素
 * 			7.indexOf(Object o)、lastIndexOf(Object o) 获取指定元素的索引
 * 			8.isEmpty() 集合是否为空
 * 			9.remove(int index)、remove(Object o) 删除指定索引的元素或指定元素
 * 			10.set(int index, E element) 将指定索引出的元素替换为指定元素
 * 			11.size() 获取集合的元素的个数
 * 			12.toArray() 集合转为数组
 * 			13.forEach(Consumer<? super E> action) 遍历集合
 * 
 * @author junki
 * @date 2019年3月19日
 */

/**
 * LinkedList:
 * 		1.特征：
 * 			1.底层数据结构是双向链表、也可以作为队列（先进先出）、栈（先进后出）来使用
 * 			2.没有扩容的概念
 * 			3.有顺序、可重复、可以为null
 * 			4.是不同步的、单线程的、不安全的
 * 				如果要安全的list：
 * 					List list = Collections.synchronizedList(new LinkedList(...)); 
 * 			5.查询慢、插入删除快。			
 * 
 * 		2.常用方法：
 * 			1.List接口方法：
 * 				add()\get()\remove()\clear()\set()\contains()\size()\indexOf()\isEmpty
 * 			2.Deque接口方法：
 * 				1.add(E e) 添加一个元素
 * 				2.addFirst(E e)\addLast(E e) 在首位\末尾添加一个元素
 * 				3.offer()\offerFirst()\offerLast() 类似add系列方法，但是有boolean返回值
 * 				4.push() 进栈、推栈
 * 				5.pop() 出栈、弹栈
 * 				6.peek() 获取栈节点
 * 
 * @author junki
 * @date 2019年3月19日
 */

/**
 * Vector
 * 		1.特征：
 * 			1.底层实现是数组
 * 			2.可变长的数组：
 * 				默认容量是10
 * 				扩容后容量为当前容量的2倍（扩容100%）
 * 			3.有顺序、可重复、可为null、有索引（会越界）
 * 			4.是同步的、多线程的、安全的
 * 			5.单线程下执行效率比ArrayList低
 * 
 * 		2.常用方法：
 * 			1.List接口方法：
 *				add()\get()\remove()\clear()\set()\contains()\size()\indexOf()\isEmpty
 *			2.特有方法：
 *				capacity()\elementAt()\firstElement()\insertElementAt()\setElementAt()
 * 
 * @author junki
 * @date 2019年3月19日
 */

/**
 * 集合类：
 * 		又叫集合框架、容器类、容器框架。
 * 		集合就是存储对象的对象。
 * 分类：
 * 		1.数组
 * 			特征：
 * 				1.内存中，固定长度的连续的一串空间
 * 				2.存储同一数据类型
 * 				3.索引从0开始，不能越界
 * 				4.查找较快，插入删除较慢
 * 		2.List
 * 			常用类：ArrayList、LinkedList、Vector、Stack
 * 
 * 		3.Set
 * 			常用类：HashSet、LinkedHashSet、TreeSet
 * 
 * 		4.Map
 * 			常用类：HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 * 架构：
 * 		Iterable接口	
 * 			|
 * 			V
 * 		Collection接口	————>    AbstractCollection抽象类
 * 			|				   	 		|
 * 			V				   	 		V
 * 	————List接口			————>	  AbstractList抽象类
 *  |		|				   	 		|
 * 	|		V				   	 		|
 * 	|	ArrayList类\Vector类      <——————————|    			
 * 	|				  |		   	 		V
 * 	|				  V		     AbstractSequentialList抽象类
 * 	|				Stack类		   	 	|
 * 	|						   	 		V
 * 	|————————————————————————————>	 LinkedList类
 * 
 */

/**
 * enum枚举
 * 		1.定义：
 * 			引用数据类型。
 * 			使用类穷举法。
 * 		2.使用：
 * 			1.第一种使用方法：
 * 				基本使用方法，全是常量，逗号分隔。
 * 			2.第二种使用方法：
 * 				高级使用方法，私有属性，getter/setter方法，构造方法
 * 				构造方法私有，只能内部调用。
 * 		3.注意事项：
 * 			枚举的第一行必须是常量，多个枚举常量逗号分隔。
 * 
 * 
 * 
 * @author junki
 * @date 2019年3月25日
 */


/**
 * Math类：
 * 		1.简介：
 * 			是一个被final修饰的数学工具类，构造方法私有
 * 		2.常用方法：
 * 			最大值最小值：max()\min()
 * 			随机数：random() 取值范围[0,1)
 * 			天花板和地板：ceil()\floor() 
 * 			四舍五入取整：round()
 * 			m的n次方：pow(m,n)
 * 
 * 
 * @author junki
 * @date 2019年3月25日
 */


/**
 * Random类：
 * 		1.简介：
 * 			默认使用48位种子生成随机数，最多可提供32个伪随机生成位。
 * 		2.常用方法：
 * 			nexInt()：默认从int的整个取值空间随机取值
 * 			...
 * 		3.注意事项：
 * 			1.无参构造，不使用seed，默认使用当前时间戳作为种子
 * 			2.有参构造，使用指定seed，相同seed的多个random对象，随机序列相同
 * 			
 * 		
 * 
 * @author junki
 * @date 2019年3月25日
 */

/**
 * String：
 * 		1.简介：
 * 			被final修饰的类，字符串常量，引用数据类型
 * 		2.常用方法：
 * 			toCharArray()\charAt()\length()\
 * 			substring(beginIndex, endIndex) 包前不包后\
 * 			split()\indexOf()\replace(char oldChar, char newChar)\
 * 			startsWith(String prefix)\
 * 			toLowerCase()\toUpperCase() 切换大小写
 * 			trim() 去除首尾空格	
 * 
 * 
 * @author junki
 * @date 2019年3月25日
 */

//user，银行卡 list 转账  系统 注册用户 身份证  查询是否有卡，余额，转账

/**
 * IO流：
 * 		1.常用类：
 * 			字节流：
 * 				InputStream：FileInputStream（直接继承）、BufferedInputStream（继承FilterInputStream）
 * 				OutputStream：FileOutputStream（直接继承）、BufferedOutputStream（继承FilterOutputStream）
 * 			字符流：
 * 				Reader：FileReader（继承InputStreamReader）、BufferedReader（直接继承）
 * 				Writer：FileWriter（继承OutputStreamWriter）、BufferedWriter（直接继承）
 * 		2.分类：
 * 			1.按照流的方向：输入流、输出流
 * 			2.按照读取的内容：字节流、字符流
 * 				用记事本打开不乱码的，可用字符流，其他的用字节流。
 * 			3.按照流的功能：节点流、处理流
 * 				节点流：FileReader  处理流：BufferedReader
 * 
 * @author junki
 * @date 2019年3月27日
 */



public class Note{}
