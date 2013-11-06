package service;

import java.util.Date;

import model.Employee;
import model.Training;
import model.TrainingEmployeeDet;

public interface TrainingEmployeeService {


void saveorUpdate(Employee emp, Training tr, Date endDate);
TrainingEmployeeDet getData(Object object);
void saveorUpdate(TrainingEmployeeDet tr);
}
