package service.impl;

import java.util.List;

import model.CommonBean;
import model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.EmployeeService;
import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.UserTypeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
//	@Autowired
//	private LoginDao loginDao;
	@Autowired
	private DepartmentDao departmentDao;
//	@Autowired
//	private DesignationDao designationDao;
	@Autowired
	private UserTypeDao roleDao;

	@Override
	public void saveOrUpdate(CommonBean commonBean) {
		employeeDao.saveOrUpdate(commonBean);
		//loginDao.saveOrUpdate(commonBean);
	}

	@Override
	public List<String> getDepartment() {
		List<String> departments =  departmentDao.getData();
		return departments;
	}
//	
//	@Override
//	public List<String> getDesignation() {
//		List<String> designations =  designationDao.getData();
//		return designations;
//	}

	@Override
	public List<String> getRoles() {
		List<String> roles =  roleDao.getData();
		return roles;
	}

	@Override
	public List<Employee> getEmp() {
		List<Employee> emp=employeeDao.getData();
		return emp;
	}

	@Override
	public Employee emailCheck(String emailid) {
		Employee emp=employeeDao.getEmail(emailid);
		return emp;
	}

	@Override
	public Employee employeeCheck(String employeeId) {
		Employee emp=employeeDao.getEmployeeID(employeeId);
		return emp;
	}
	@Override
	public List<Employee> getEmployees(String employeeId, String empName) {
		
		return employeeDao.getEmployees(employeeId, empName);
	}

	@Override
	public Employee getEmployeeID(String employeeId) {
		
		return employeeDao.getEmployeeID(employeeId);
	}


}
