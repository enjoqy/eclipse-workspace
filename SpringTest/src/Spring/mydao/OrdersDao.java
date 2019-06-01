package Spring.mydao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrdersDao {
	
	//jdbcTemplate模板
	private JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//小王少钱的方法
	public void lessMoney() {
		String sql = "update account set salary=salary-? where username=?";
		jdbcTemplate.update(sql,"1000","小王");
	}

	//小马多钱的方法
	public void moreMoney() {
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql,"1000","小马");
	}
}
