package dao.impl;

import java.util.List;

import model.CommonBean;
import model.Department;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.DepartmentDao;
@Repository
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	@Override
	public void saveOrUpdate(CommonBean commonBean) {
		Department department=new Department();
		department.setDeptName(commonBean.getDepartmentName());
		getHibernateTemplate().saveOrUpdate(department);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getData() {
		
		List<String> dep=getHibernateTemplate().findByNamedQuery("departments");
		return dep;
	}
	@Override
	@SuppressWarnings("unchecked")
	public Department getDepartment(String departmentName) {
		List<Department> dept=getHibernateTemplate().findByNamedQuery("deptName", departmentName);
		if (dept.size() > 0) {
			return dept.get(0);
		}
		return null;
	}

}
