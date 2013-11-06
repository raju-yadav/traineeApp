package model;

// Generated Feb 7, 2010 6:52:14 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * Login generated by hbm2java
 */
public class Login implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6591615158093483221L;
	private long loginId;
	private String userName;
	private String password;

	public Login() {
	}

	public Login(long loginId, String userName, String password) {
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
	}

	public Login(long loginId, String userName, String password,
			Date loginTime, Date logoutTime) {
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		
	}

	public long getLoginId() {
		return this.loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}