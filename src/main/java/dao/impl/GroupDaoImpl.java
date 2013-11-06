package dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import model.CommonBean;
import model.Group;
import dao.GroupDao;
@Repository
public class GroupDaoImpl extends HibernateDaoSupport implements GroupDao{

	@Override
	public void saveOrUpdate(CommonBean commonBean) {
	Group group=new Group();
		group.setGroupName(commonBean.getGroupName());
		getHibernateTemplate().saveOrUpdate(group);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getData() {
		List<String> gr=getHibernateTemplate().findByNamedQuery("group");
		return gr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Group getGroup(String groupName) {
		List<Group> group=getHibernateTemplate().findByNamedQuery("groupName", groupName);
		if(group.size()>0){
			return group.get(0);
		}
		return null;
	}

}
