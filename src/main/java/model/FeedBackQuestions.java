package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FeedBackQuestions implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4496020585513358475L;
	private long questionid;
	private String questions;
	private FeedBackObjectives feedBackObjectives;
	private Set<FeedBackResults> feedBackResults = new HashSet<FeedBackResults>(0);
	private Date creationDate;
	
	public long getQuestionid() {
		return questionid;
	}
	public void setQuestionid(long questionid) {
		this.questionid = questionid;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public FeedBackObjectives getFeedBackObjectives() {
		return feedBackObjectives;
	}
	public void setFeedBackObjectives(FeedBackObjectives feedBackObjectives) {
		this.feedBackObjectives = feedBackObjectives;
	}
	public Set<FeedBackResults> getFeedBackResults() {
		return feedBackResults;
	}
	public void setFeedBackResults(Set<FeedBackResults> feedBackResults) {
		this.feedBackResults = feedBackResults;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
}
