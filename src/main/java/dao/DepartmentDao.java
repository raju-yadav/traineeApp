package dao;

import java.util.List;

import model.CommonBean;
import model.Department;

public interface DepartmentDao {
public void saveOrUpdate(CommonBean commonBean);

public List<String> getData();

public Department getDepartment(String departmentName);
}
