package Spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Dao {


	//�õ�jdbcTemplate����
	private	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void add() {




		//�������ݿ���Ϣ
		//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//		dataSource.setUrl("jdbc:mysql:///mydb");
		//		dataSource.setUsername("root");
		//		dataSource.setPassword("123");

		//����jdbcTemplate������������Դ
		//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
		String sql = "insert into mydb1 values(?,?,?,?)";
		jdbcTemplate.update(sql,"11", "����", "520", "23");


	}

	
}
