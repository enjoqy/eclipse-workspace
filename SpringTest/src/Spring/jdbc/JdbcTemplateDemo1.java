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

	//1���������ݿ����Ӳ���
	/*@Test
	public void add() {
		//�������ݿ���Ϣ
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql:///mydb");
	    dataSource.setUsername("root");
	    dataSource.setPassword("123");

	    //����jdbcTemplate������������Դ
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	    //ʹ��jdbcTmplate������ķ���ʵ�ֲ���
	    String sql = "insert into mydb1 values(?,?,?,?)";
	    int rows = jdbcTemplate.update(sql, "7" , "111", "121","212");
	    System.out.println(rows);

	}
	 */
	//2,�������ݿ��޸Ĳ���
	/*@Test
	public void update() {
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//ʹ��jdbcTemplate������ķ���ʵ�ֲ���
		String sql = "update mydb1 set password=? where name=?";
		int rows = jdbcTemplate.update(sql, "888888", "111");
		System.out.println(rows);

	}
	 */
	/*//�������ݿ�ɾ������
	@Test
	public void delete() {
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//ʹ��jdbcTemplate������ķ���ʵ�ֲ���
		String sql = "delete from mydb1 where password=?";
		int rows = jdbcTemplate.update(sql, "888888");
		System.out.println(rows);
	}*/

	@Test
	public void check() {
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//ʹ��jdbcTemplate������ķ���ʵ�ֲ���
		String sql = "select count(*) from mydb1";
		int rows = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(rows);
	}
	


	
	@Test
	public void testJDBC() {  //����ĳ����¼
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = DriverManager.getConnection("jdbc:mysql:///mydb", "root", "123");
			//��дsql���
			String sql = "select * from mydb1 where password = ?";
			//Ԥ����sql
			psmt = conn.prepareStatement(sql);
			//���ò���
			psmt.setString(1, "321");
			//ִ��sql
			rs = psmt.executeQuery();
			while(rs.next()) {
				//�õ����ؽ��ֵ
				String name = rs.getString("name");
				String age = rs.getString("age");
				String password = rs.getString("password");
				//�ŵ�user������
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
	public void testList() {  //����ĳ���������Ϣ
		
//		ComboPooledDataSource dataSource = new ComboPooledDataSource(); 
//		dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		dataSource.setJdbcUrl("jdbc:mysql:///mydb");
//		dataSource.setUser("root");
//		dataSource.setPassword("123");
		
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//ʹ��jdbcTemplate������ķ���ʵ�ֲ���
		String sql = "select * from mydb1";
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(list);
	}
	
	@Test
	public void testObject() {  //����ĳ���������Ϣ
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//ʹ��jdbcTemplate������ķ���ʵ�ֲ���
		String sql = "select * from mydb1 where name = ?";
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "����");
		System.out.println(user);
	}

}

//��Ҫ�Լ���װ���ݣ��Լ�ʵ�ֽӿ��еķ���
class MyRowMapper implements org.springframework.jdbc.core.RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		
		//1.�ڽ����������ݵõ�
		String name = rs.getString("name");
		String age = rs.getString("age");
		String password = rs.getString("password");
		//2.�ѵõ������ݷ�װ��������
		User user = new User();
		user.setAge(age);
		user.setName(name);
		user.setPassword(password);
		return user;
	}
	
}
