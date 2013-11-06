package model;

import java.util.HashSet;
import java.util.Set;

public class Employee implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801841497149968022L;
	private String employeeId;
	private String employeeName;
	private String designationId;
	private String emailid;
	private String reportmanager;
	private UserType type;
	private Department dept;
	private Group group;
	private Set<Training> training= new HashSet<Training>(0);
	private Set<TrainingEmployeeDet> trempDet=new HashSet<TrainingEmployeeDet>(0);
	private Login login;
	public Employee(){}
	public Employee(String employeeId){
		this.employeeId=employeeId;
	}

	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	
	public String getDesignationId() {
		return designationId;
	}
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getReportmanager() {
		return reportmanager;
	}
	public void setReportmanager(String reportmanager) {
		this.reportmanager = reportmanager;
	}
	
	public Set<Training> getTraining() {
		return training;
	}
	public void setTraining(Set<Training> training) {
		this.training = training;
	}
	public Login getLogin() {
		login.setUserName(getEmployeeId());
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Set<TrainingEmployeeDet> getTrempDet() {
		return trempDet;
	}
	public void setTrempDet(Set<TrainingEmployeeDet> trempDet) {
		this.trempDet = trempDet;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}