package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Training implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3696297774585847933L;
	private long trainingId;
	private String trainingName;
	private String trainingtype;
	private Group group;
	private Date fromDate;
	private Date toDate;
	private Department department;
	private Set<FeedBackResults> feedBackResults = new HashSet<FeedBackResults>(0);
	private Set<TrainingEmployeeDet> trempDet=new HashSet<TrainingEmployeeDet>(0);
	private Employee trainerId;
	
	public long getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	
	public String getTrainingtype() {
		return trainingtype;
	}
	public void setTrainingtype(String trainingtype) {
		this.trainingtype = trainingtype;
	}

	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Set<FeedBackResults> getFeedBackResults() {
		return feedBackResults;
	}
	public void setFeedBackResults(Set<FeedBackResults> feedBackResults) {
		this.feedBackResults = feedBackResults;
	}
	public Employee getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Employee trainerId) {
		this.trainerId = trainerId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
