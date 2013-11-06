package dao;

import java.util.Date;

import model.Employee;
import model.Training;
import model.TrainingEmployeeDet;

public interface TrainingEmployeeDetDao {
public void saveorUpdate(Employee emp, Training tr, Date endDate);

public TrainingEmployeeDet getData(Object object);

public void saveorUpdate(TrainingEmployeeDet tr);
}
