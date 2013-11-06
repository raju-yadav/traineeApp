package dao.impl;

import java.util.List;

import model.Login;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.LoginDao;

@Repository
public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao  {
	@SuppressWarnings("unchecked")
	public Login loadUserByUsername(String username) {
		try {
			DetachedCriteria criteria = DetachedCriteria
			        .forClass(Login.class);
			criteria.add(Restrictions.eq("USER_NAME", username));
			List<Login> userList = getHibernateTemplate()
			        .findByCriteria(criteria);
			if (userList.size() > 0) {
				Login login = userList.get(0);
				
				return login;
			}
		} catch (DataAccessException e) {
			e.getMessage();
		}
		return null;

	}
	@SuppressWarnings("unchecked")
	public Login userCheck(Login login) {
		String loginName = login.getUserName();
		String loginPassword = login.getPassword();
		Object[] params = { loginName, loginPassword };
		List<Login> empLogins = getHibernateTemplate().findByNamedQuery(
		        "login.query.string", params);
		
		if (empLogins.size() > 0) {
			return empLogins.get(0);
		}

		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String getpwd(String userName) {
		String pwd=null;
		DetachedCriteria criteria = DetachedCriteria
		        .forClass(Login.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<Login> userList = getHibernateTemplate().findByCriteria(criteria);
		if (userList.size() > 0) {
			 Login login = userList.get(0);
			pwd=login.getPassword();
		}
		
		return pwd;
	}
}
