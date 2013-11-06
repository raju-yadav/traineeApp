package service;

import model.Login;


public interface LoginService {

	public Login getLoggedInUser(String name);
	public Login userCheck(Login login);
	public String getName(String userName);
	public long getRole(Login login);
	public String getPassword(String userName);
}
