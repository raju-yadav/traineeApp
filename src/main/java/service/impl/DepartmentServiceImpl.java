package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DepartmentDao;

import model.CommonBean;
import model.Department;
import service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	@Override
	public void saveOrUpdate(CommonBean commonBean) {
		departmentDao.saveOrUpdate(commonBean);
		
	}
	@Override
	public Department getDept(String departmentName) {
		Department dept=departmentDao.getDepartment(departmentName);
		return dept;
	}

}
