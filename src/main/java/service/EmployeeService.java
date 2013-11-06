package service;


import java.util.List;

import model.CommonBean;
import model.Employee;

public interface EmployeeService {
	public void saveOrUpdate(CommonBean commonBean);
	public List<String> getDepartment();
//	public List<String> getDesignation();
	public List<String> getRoles();
	public List<Employee> getEmp();
	public Employee emailCheck(String emailid);
	public Employee employeeCheck(String employeeId);
	public List<Employee> getEmployees(String employeeId, String empName);
	public Employee getEmployeeID(String employeeId);
	
}
