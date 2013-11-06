package dao.impl;

import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.UserTypeDao;
@Repository
public class UserTypeDaoImpl extends HibernateDaoSupport implements UserTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getData() {
		List<String> type=getHibernateTemplate().findByNamedQuery("role");
		return type;
	}

}
