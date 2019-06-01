package Spring¿ò¼Ü;

public class UserService {
	
	private UserDao userDao;
	
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	public void add(){
		System.out.println("Service..........");
		
		userDao.add();
	}

}
