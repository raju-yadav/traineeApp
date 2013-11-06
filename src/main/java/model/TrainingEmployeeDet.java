package model;

import java.util.Date;

public class TrainingEmployeeDet implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5614338519874952598L;
private long id;
private Employee employee;
private Training training;
private int flag;
private Date EndDate;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public Training getTraining() {
	return training;
}
public void setTraining(Training training) {
	this.training = training;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public Date getEndDate() {
	return EndDate;
}
public void setEndDate(Date endDate) {
	EndDate = endDate;
}


}
