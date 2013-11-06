package model;

import java.util.Date;

public class CommonBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7762294939921551580L;
	
	// Training Beans
	private long trainingId;
	private String trainingName;
	private String trainingtype;
	private String departmentName;
	private String trainerName;
	private long group;
	private Date trFrom;
	private Date trEnd;
	private String venu;
	
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public long getGroup() {
		return group;
	}
	public void setGroup(long group) {
		this.group = group;
	}
	public Date getTrFrom() {
		return trFrom;
	}
	public void setTrFrom(Date trFrom) {
		this.trFrom = trFrom;
	}
	public Date getTrEnd() {
		return trEnd;
	}
	public void setTrEnd(Date trEnd) {
		this.trEnd = trEnd;
	}
	
	//Feedback Beans
	private Date dateOfFeedback;
	private String feedbackTitle;
	private String facultyName;
	private int trObjClearRadio;
	private int trObjAchievedRadio;
	private int trObjContentRadio;
	private int trObjRateRadio;
	private int trObjReadingRadio;
	private int trObjTopiceRadio;
	private int trObjJobRadio;
	private int trObjPresentedRadio;
	private int trObjInterestRadio;
	private int trObjLevelRadio;
	private int trObjTrainerRadio;
	private int trObjTrainrRadio;
	private int trObjUrsantRadio;
	private int trObjSessionRadio;
	private int trObjAnsRadio;
	private String feedbackPerspective;
	private String feedbackSuggestion;
	
	public Date getDateOfFeedback() {
		return dateOfFeedback;
	}
	public void setDateOfFeedback(Date dateOfFeedback) {
		this.dateOfFeedback = dateOfFeedback;
	}
	public String getFeedbackTitle() {
		return feedbackTitle;
	}
	public void setFeedbackTitle(String feedbackTitle) {
		this.feedbackTitle = feedbackTitle;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public int getTrObjClearRadio() {
		return trObjClearRadio;
	}
	public void setTrObjClearRadio(int trObjClearRadio) {
		this.trObjClearRadio = trObjClearRadio;
	}
	public int getTrObjAchievedRadio() {
		return trObjAchievedRadio;
	}
	public void setTrObjAchievedRadio(int trObjAchievedRadio) {
		this.trObjAchievedRadio = trObjAchievedRadio;
	}
	public int getTrObjContentRadio() {
		return trObjContentRadio;
	}
	public void setTrObjContentRadio(int trObjContentRadio) {
		this.trObjContentRadio = trObjContentRadio;
	}
	public int getTrObjRateRadio() {
		return trObjRateRadio;
	}
	public void setTrObjRateRadio(int trObjRateRadio) {
		this.trObjRateRadio = trObjRateRadio;
	}
	public int getTrObjReadingRadio() {
		return trObjReadingRadio;
	}
	public void setTrObjReadingRadio(int trObjReadingRadio) {
		this.trObjReadingRadio = trObjReadingRadio;
	}
	public int getTrObjTopiceRadio() {
		return trObjTopiceRadio;
	}
	public void setTrObjTopiceRadio(int trObjTopiceRadio) {
		this.trObjTopiceRadio = trObjTopiceRadio;
	}
	public int getTrObjJobRadio() {
		return trObjJobRadio;
	}
	public void setTrObjJobRadio(int trObjJobRadio) {
		this.trObjJobRadio = trObjJobRadio;
	}
	public int getTrObjPresentedRadio() {
		return trObjPresentedRadio;
	}
	public void setTrObjPresentedRadio(int trObjPresentedRadio) {
		this.trObjPresentedRadio = trObjPresentedRadio;
	}
	public int getTrObjInterestRadio() {
		return trObjInterestRadio;
	}
	public void setTrObjInterestRadio(int trObjInterestRadio) {
		this.trObjInterestRadio = trObjInterestRadio;
	}
	public int getTrObjLevelRadio() {
		return trObjLevelRadio;
	}
	public void setTrObjLevelRadio(int trObjLevelRadio) {
		this.trObjLevelRadio = trObjLevelRadio;
	}
	public int getTrObjTrainerRadio() {
		return trObjTrainerRadio;
	}
	public void setTrObjTrainerRadio(int trObjTrainerRadio) {
		this.trObjTrainerRadio = trObjTrainerRadio;
	}
	public int getTrObjTrainrRadio() {
		return trObjTrainrRadio;
	}
	public void setTrObjTrainrRadio(int trObjTrainrRadio) {
		this.trObjTrainrRadio = trObjTrainrRadio;
	}
	public int getTrObjUrsantRadio() {
		return trObjUrsantRadio;
	}
	public void setTrObjUrsantRadio(int trObjUrsantRadio) {
		this.trObjUrsantRadio = trObjUrsantRadio;
	}
	public int getTrObjSessionRadio() {
		return trObjSessionRadio;
	}
	public void setTrObjSessionRadio(int trObjSessionRadio) {
		this.trObjSessionRadio = trObjSessionRadio;
	}
	public int getTrObjAnsRadio() {
		return trObjAnsRadio;
	}
	public void setTrObjAnsRadio(int trObjAnsRadio) {
		this.trObjAnsRadio = trObjAnsRadio;
	}
	public String getFeedbackPerspective() {
		return feedbackPerspective;
	}
	public void setFeedbackPerspective(String feedbackPerspective) {
		this.feedbackPerspective = feedbackPerspective;
	}
	public String getFeedbackSuggestion() {
		return feedbackSuggestion;
	}
	public void setFeedbackSuggestion(String feedbackSuggestion) {
		this.feedbackSuggestion = feedbackSuggestion;
	}
	
	
	// Employee Beans
	private String employeeId;
	private String employeeName;
	private String usrName;
	private String password;
	private long deptId;
	private String designationId;
	private long userTypeId;
	private String emailid;
	private String reportmanager;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public String getDesignationId() {
		return designationId;
	}
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}
	public long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(long userTypeId) {
		this.userTypeId = userTypeId;
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
	
	//Group Beans
	private String groupName;
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
//feedback Templates
	private String trobj;
	private String trque;
	private long objid;
	public String getTrobj() {
		return trobj;
	}
	public void setTrobj(String trobj) {
		this.trobj = trobj;
	}
	public String getTrque() {
		return trque;
	}
	public void setTrque(String trque) {
		this.trque = trque;
	}
	public long getObjid() {
		return objid;
	}
	public void setObjid(long objid) {
		this.objid = objid;
	}
	

	//Invitation Beans
			private String [] selectedMails;

			public String [] getSelectedMails() {
				return selectedMails;
			}
			public void setSelectedMails(String [] selectedMails) {
				this.selectedMails = selectedMails;
			}

			
		

			private String timeSlot;
			public String getTimeSlot() {
				return timeSlot;
			}
			public void setTimeSlot(String timeSlot) {
				this.timeSlot = timeSlot;
			}
			public String getVenu() {
				return venu;
			}
			public void setVenu(String venu) {
				this.venu = venu;
			}
		private String fromDate;
		private String toDate;
		private String trainingType;

		public String getFromDate() {
			return fromDate;
		}
		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}
		public String getToDate() {
			return toDate;
		}
		public void setToDate(String toDate) {
			this.toDate = toDate;
		}
		public String getTrainingType() {
			return trainingType;
		}
		public void setTrainingType(String trainingType) {
			this.trainingType = trainingType;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
}
