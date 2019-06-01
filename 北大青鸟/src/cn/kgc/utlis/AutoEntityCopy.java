package cn.kgc.utlis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 实现实体类的生成
 * 
 * @author zhuhao
 * @date 2019年3月16日
 */
public class AutoEntityCopy {
	
	private static StringBuilder sb = new StringBuilder();
	private static String entityName = null;
	private static String defaultPackagePath = null;
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static Connection defaultConn = null;
	
	//从配置文件读取需要的内容
	static {
		InputStream is = AutoEntityCopy.class.getClassLoader().getResourceAsStream("test.properties");
		Properties p = new Properties();
		try {
			p.load(is);
			defaultPackagePath = p.getProperty("defaultPackagePath");
			if(defaultPackagePath == null) {
				defaultPackagePath = "cn.kgc.entity";
			}
			driver = p.getProperty("jdbc.driver");
			url = p.getProperty("jdbc.url");
			user = p.getProperty("jdbc.user");
			password = p.getProperty("jdbc.password");
			
			Class.forName(driver);
			defaultConn = DriverManager.getConnection(url, user, password);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建实体类
	 * @param conn 数据库连接对象
	 * @param table 表名
	 * @param packagePath 实体类包名
	 * @param constructors 是否创建构造方法
	 * @param getSet 是否创建get方法和set方法
	 * @param entityName 实体类的名字，为了防止大小写出错，进行先转小写在转大写处理
	 */
	public static void creatEntity(Connection conn, String table, String packagePath, boolean constructors, boolean getSet) {
		entityName = table.substring(0, 1).toUpperCase() + table.substring(1, table.length()).toLowerCase();
		createCode(conn, table, packagePath, constructors, getSet);
		System.out.println(sb);
		createFile(packagePath, table);
		System.out.println("实体类生成完毕，生成的文件位于" + " src/" + packagePath.replace(".", "/") + "/" + entityName + ".java");
	}
	public static void creatEntity(Connection conn, String table, String packagePath) {
		creatEntity(conn, table,packagePath, true, true);
	}
	public static void creatEntity(String table, String packagePath) {
		creatEntity(defaultConn, table,packagePath);
	}
	public static void creatEntity(Connection conn, String table) {
		creatEntity(conn, table, defaultPackagePath);
	}
	public static void creatEntity(String table) {
		creatEntity(defaultConn, table, defaultPackagePath);
	}
	
	/**
	 * 将产生的实体生成一个文件
	 */
	private static void createFile(String packagePath, String table) {
		String filePath = "src/" + packagePath.replace(".", "/") + "/" + entityName + ".java";
		
		File file = new File("src/" + packagePath.replace(".", "/"));
		file.mkdirs();
		
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(sb.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将表包名，类名，构造器，拼接成字符串
	 * 
	 * @param conn
	 * @param table
	 * @param packagePath
	 * @param constructors
	 * @param getSet
	 */
	private static void createCode(Connection conn, String table, String packagePath, boolean constructors, boolean getSet) {
		StringBuilder constructorValue = new StringBuilder();
		StringBuilder constructorContent = new StringBuilder();
		StringBuilder getSetCode = new StringBuilder();
		
		sb.append("public class " + entityName + "{ \n");
		
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from " + table);  //执行sql语句获得表名
			ResultSetMetaData rsmd = rs.getMetaData();
			
			for(int index=1; index<=rsmd.getColumnCount(); index++) {
				
				String columnName = rsmd.getColumnName(index);
				String columnType = rsmd.getColumnTypeName(index);
				
				columnType = changeType(columnType);  //将mysql数据类型的格式转换为java中的格式
				
				//拼接实体属性
				sb.append("\tprivate " + columnType + " " + columnName + ";\n");
				
				//拼接构造方法的参数列表
				constructorValue.append(columnType + " " + columnName + ", ");
				
				//拼接构造方法的方法体
				constructorContent.append("\t\tthis." + columnName + " = " + columnName + ";\n");
				
				//拼接get和set方法
				getSetCode.append("\n\n\tpublic " + columnType + " get" + columnName.substring(0, 1).toUpperCase() 
						+columnName.substring(1, columnName.length()).toLowerCase()
						+ "(){\n" + "\t\treturn " + columnName.toLowerCase() + ";\n\t};"
						+"\n\n\tpublic void" + " set" + columnName.substring(0,1).toUpperCase() + columnName.substring(1, columnName.length()).toLowerCase()
						+ "(" + columnType + " " + columnName + "){\n" + "\t\tthis." + columnName + " = " + columnName + ";\n\t}");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//整合构造方法
		if(constructors == true) {
			sb.append("\n\tpublic " + entityName + "(){\n\n\t}");
			sb.append("\n\n\tpublic " + entityName + "(" + constructorValue.substring(0, constructorValue.length()-2) + "){\n");
			sb.append(constructorContent + " \t}");
		}
		
		//整合get和set方法
		if(getSet == true) {
			sb.append(getSetCode);
		}
		
		//补充包的路径
		sb.insert(0, "package " + packagePath + ";\n\n");
		sb.append("\n}");
	}
	
	/**
	 * switch接受的参数类型有10种，分别是基本类型的byte,short,int,char，
	 * 以及引用类型的String(只有JavaSE 7 和以后的版本可以接受String类型参数),
	 * enum和byte,short,int,char的封装类Byte,Short,Integer,Character
	 * 
	 * @return
	 */
	private static String changeType(String columnType) {
		switch(columnType) {
		case "TINYINT":return "Byte";
		case "SMALLINT":return "Short";
		case "INT":return "Integer";
		case "BIGINT":return "Long";
		case "FLOAT":return "Float";
		case "DOUBLE":return "Double";
		
		case "NUMERIC":return "BigDecimal";
		case "CHAR(1)":return "Character";
		case "BIT":return "Boolean";
		case "CHAR(1)(‘Y’或‘N’)":return "Boolean";
		case "VARCHAR":return "String";
		
		case "DATE": autoImporte("Date");return "Date";
		case "TIME":return "java.sql.Time";
		case "TIMESTAMP":return "java.sql.Timestamp";
		
		default: return columnType;
		}
	}

	/**
	 * 自动导包
	 * @param classPath
	 */
	private static void autoImporte(String classPath) {
		sb.insert(0, "importe java.utile." + classPath + ";\n\n");
	}


}
