package Spring.mydao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrdersDao {
	
	//jdbcTemplateģ��
	private JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//С����Ǯ�ķ���
	public void lessMoney() {
		String sql = "update account set salary=salary-? where username=?";
		jdbcTemplate.update(sql,"1000","С��");
	}

	//С���Ǯ�ķ���
	public void moreMoney() {
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql,"1000","С��");
	}
}
