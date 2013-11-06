package dao;

import java.util.List;

import model.CommonBean;
import model.Employee;
import model.Login;

public interface EmployeeDao {
	public void saveOrUpdate(CommonBean commonBean);
	public Employee getEmployeeInfo(String employeeId);
	public List<Employee> getData();
	public Employee getEmail(String emailid);
	public Employee getEmployeeID(String employeeId);
	public String getName(String userName);
	public long getRole(Login login);
	public List<Employee> getEmployees(String id,String name);
}
