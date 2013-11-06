package service.impl;

import model.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.LoginService;
import dao.EmployeeDao;
import dao.LoginDao;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private EmployeeDao empDao;
	
	public Login getLoggedInUser(String name) {
      return loginDao.loadUserByUsername(name);
	}

	@Override
	public Login userCheck(Login login) {
		return loginDao.userCheck(login);
		
	}

	@Override
	public String getName(String userName) {
		String name=empDao.getName(userName);
		return name;
	}

	@Override
	public long getRole(Login login) {
		long id=empDao.getRole(login);
		return id;
	}

	@Override
	public String getPassword(String userName) {
		
		return loginDao.getpwd(userName);
	}
}
