package service;

import model.CommonBean;
import model.Department;

public interface DepartmentService {
public void saveOrUpdate(CommonBean commonBean);

public Department getDept(String departmentName);
}
