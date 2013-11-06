package dao;

import model.Login;



public interface LoginDao {

	public Login loadUserByUsername(String username);
	public Login userCheck(Login yogaLogin);
	public String getpwd(String userName);

	
}
