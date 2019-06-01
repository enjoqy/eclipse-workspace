package cn.kgc.myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 * 测试连接JDBC
 * 
 * @author zhuhao
 * @date 2019年3月15日
 */
public class DemoJDBC {

	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";	 //驱动名称
		String url = "jdbc:mysql:///mydb"; 			 //url地址
		String user = "root";               		 //用户名，密码
		String password = "1234";
		
		try {
			//1.加载驱动
			Class.forName(driver);
			
			//2.创建连接对象
			Connection con = DriverManager.getConnection(url, user, password);
			
			if(!con.isClosed()) {
				System.out.println("已连接数据库！");
			}
			
			//3.拼写sql语句
			String sql = "select*from info";
			
			//4.创建statement对象
			Statement st = con.createStatement();
			
			//5.执行sql语句，返回结果集
			ResultSet rs = st.executeQuery(sql);
			
			//6.遍历结果集
			while(rs.next()) {
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("age") + "\t");
				System.out.print(rs.getString("sex") + "\t");
				System.out.print(rs.getString("adress") + "\t");
				
				System.out.println();
			}
			
			//7.关闭资源
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
