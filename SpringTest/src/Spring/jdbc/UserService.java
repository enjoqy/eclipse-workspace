package Spring.jdbc;

public class UserService {
	
	private Dao dao ;
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public void add() {
		dao.add();
	}

}
