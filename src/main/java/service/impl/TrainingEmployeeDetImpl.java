package service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TrainingEmployeeDetDao;

import model.Employee;
import model.Training;
import model.TrainingEmployeeDet;
import service.TrainingEmployeeService;
@Service
public class TrainingEmployeeDetImpl implements TrainingEmployeeService{

@Autowired
private TrainingEmployeeDetDao trempdao;

	@Override
	public void saveorUpdate(Employee emp, Training tr, Date endDate) {
		trempdao.saveorUpdate(emp,tr,endDate);
		
	}

	@Override
	public TrainingEmployeeDet getData(Object object) {
		return trempdao.getData(object);
		
	}

	@Override
	public void saveorUpdate(TrainingEmployeeDet tr) {
		trempdao.saveorUpdate(tr);
		
	}

}
