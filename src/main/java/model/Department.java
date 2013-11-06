package model;

import java.util.HashSet;
import java.util.Set;

public class Department implements java.io.Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -7811418013241716411L;
private long deptId;
private String deptName;
private Set<Training> training=new HashSet<Training>(0);


public Set<Training> getTraining() {
	return training;
}
public void setTraining(Set<Training> training) {
	this.training = training;
}
public long getDeptId() {
	return deptId;
}
public void setDeptId(long deptId) {
	this.deptId = deptId;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}

}
