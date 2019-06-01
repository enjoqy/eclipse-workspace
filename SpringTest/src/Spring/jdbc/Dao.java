package Spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Dao {


	//得到jdbcTemplate对象
	private	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void add() {




		//设置数据库信息
		//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//		dataSource.setUrl("jdbc:mysql:///mydb");
		//		dataSource.setUsername("root");
		//		dataSource.setPassword("123");

		//创建jdbcTemplate对象，设置数据源
		//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
		String sql = "insert into mydb1 values(?,?,?,?)";
		jdbcTemplate.update(sql,"11", "张雷", "520", "23");


	}

	
}
