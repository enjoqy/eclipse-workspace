package Spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcTemplateDemo1 {

	//1，设置数据库增加操作
	/*@Test
	public void add() {
		//设置数据库信息
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql:///mydb");
	    dataSource.setUsername("root");
	    dataSource.setPassword("123");

	    //创建jdbcTemplate对象，设置数据源
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	    //使用jdbcTmplate对象里的方法实现操作
	    String sql = "insert into mydb1 values(?,?,?,?)";
	    int rows = jdbcTemplate.update(sql, "7" , "111", "121","212");
	    System.out.println(rows);

	}
	 */
	//2,设置数据库修改操作
	/*@Test
	public void update() {
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//使用jdbcTemplate对象里的方法实现操作
		String sql = "update mydb1 set password=? where name=?";
		int rows = jdbcTemplate.update(sql, "888888", "111");
		System.out.println(rows);

	}
	 */
	/*//设置数据库删除操作
	@Test
	public void delete() {
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//使用jdbcTemplate对象里的方法实现操作
		String sql = "delete from mydb1 where password=?";
		int rows = jdbcTemplate.update(sql, "888888");
		System.out.println(rows);
	}*/

	@Test
	public void check() {
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//使用jdbcTemplate对象里的方法实现操作
		String sql = "select count(*) from mydb1";
		int rows = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(rows);
	}
	


	
	@Test
	public void testJDBC() {  //返回某条记录
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			conn = DriverManager.getConnection("jdbc:mysql:///mydb", "root", "123");
			//编写sql语句
			String sql = "select * from mydb1 where password = ?";
			//预编译sql
			psmt = conn.prepareStatement(sql);
			//设置参数
			psmt.setString(1, "321");
			//执行sql
			rs = psmt.executeQuery();
			while(rs.next()) {
				//得到返回结果值
				String name = rs.getString("name");
				String age = rs.getString("age");
				String password = rs.getString("password");
				//放到user对象里
				User user = new User();
				user.setAge(age);
				user.setName(name);
				user.setPassword(password);

				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	@Test
	public void testList() {  //返回某条对象的信息
		
//		ComboPooledDataSource dataSource = new ComboPooledDataSource(); 
//		dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		dataSource.setJdbcUrl("jdbc:mysql:///mydb");
//		dataSource.setUser("root");
//		dataSource.setPassword("123");
		
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//使用jdbcTemplate对象里的方法实现操作
		String sql = "select * from mydb1";
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(list);
	}
	
	@Test
	public void testObject() {  //返回某条对象的信息
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//使用jdbcTemplate对象里的方法实现操作
		String sql = "select * from mydb1 where name = ?";
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "王五");
		System.out.println(user);
	}

}

//需要自己封装数据，自己实现接口中的方法
class MyRowMapper implements org.springframework.jdbc.core.RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		
		//1.在结果集里把数据得到
		String name = rs.getString("name");
		String age = rs.getString("age");
		String password = rs.getString("password");
		//2.把得到的数据封装到对象里
		User user = new User();
		user.setAge(age);
		user.setName(name);
		user.setPassword(password);
		return user;
	}
	
}
