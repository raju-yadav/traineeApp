package dao.impl;

import java.util.List;

import model.CommonBean;
import model.Department;
import model.Employee;
import model.Login;
import model.UserType;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.EmployeeDao;

@Repository
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public void saveOrUpdate(CommonBean commonBean) {

		Employee employee = new Employee();

		employee.setEmployeeId(commonBean.getEmployeeId());
		employee.setEmployeeName(commonBean.getEmployeeName());
		employee.setDesignationId(commonBean.getDesignationId());
		employee.setEmailid(commonBean.getEmailid());
		employee.setReportmanager(commonBean.getReportmanager());
		Login login=new Login();
		login.setPassword(commonBean.getPassword());
		employee.setLogin(login);
		UserType type=new UserType();
		type.setId(commonBean.getUserTypeId());
		employee.setType(type);
		Department dept=new Department();
		dept.setDeptId(commonBean.getDeptId());
		employee.setDept(dept);
		getHibernateTemplate().saveOrUpdate(employee);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Employee getEmployeeInfo(String employeeId) {
		Object[] params = {employeeId};
		List<Employee> employees = getHibernateTemplate().findByNamedQuery("employeeObject", params);

		if (employees.size() > 0) {
			return employees.get(0);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getData() {
		DetachedCriteria criteria = DetachedCriteria
		        .forClass(Employee.class);
//		criteria.add(Restrictions.eq("employeeId", userName));
		List<Employee> userList = getHibernateTemplate()
		        .findByCriteria(criteria);
		/*if (userList.size() > 0) {
			Employee employee = userList.get(0);
			String name=employee.getEmployeeName();
			return name;
		}*/
	
	return userList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Employee getEmail(String emailid) {
		List<Employee> emp=getHibernateTemplate().findByNamedQuery("emailid", emailid);
		if (emp.size() > 0) {
			return emp.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee getEmployeeID(String employeeId) {
		List<Employee> emp=getHibernateTemplate().findByNamedQuery("empid",employeeId);
		if (emp.size() > 0) {
			return emp.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getName(String userName) {
		
			DetachedCriteria criteria = DetachedCriteria
			        .forClass(Employee.class);
			criteria.add(Restrictions.eq("employeeId", userName));
			List<Employee> userList = getHibernateTemplate()
			        .findByCriteria(criteria);
			if (userList.size() > 0) {
				Employee employee = userList.get(0);
				String name=employee.getEmployeeName();
				return name;
			}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public long getRole(Login login) {
		String userid=login.getUserName();
		DetachedCriteria criteria = DetachedCriteria
		        .forClass(Employee.class);
		criteria.add(Restrictions.eq("employeeId", userid));
		List<Employee> userList = getHibernateTemplate()
		        .findByCriteria(criteria);	
		if (userList.size() > 0) {
			Employee employee = userList.get(0);
			UserType type=employee.getType();
			long id=type.getId();
			return id;
		}
		return 0;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees(String id, String name) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		if(id.trim().length()>0){
			criteria.add(Restrictions.eq("employeeId", id));
		}
		if(name.trim().length()>0){
			criteria.add(Restrictions.like("employeeName", name));
		}
		List<Employee> employees = getHibernateTemplate().findByCriteria(criteria);
		return employees;
	}
}