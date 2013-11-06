package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FeedBackObjectives implements java.io.Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 8568125323240220455L;
private long objectiveid;
private String feedObj;
private Set<FeedBackQuestions> feedquestions = new HashSet<FeedBackQuestions>(0);
private Date creationDate;

public Date getCreationDate() {
	return creationDate;
}
public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}
public String getFeedObj() {
	return feedObj;
}
public void setFeedObj(String feedObj) {
	this.feedObj = feedObj;
}

public Set<FeedBackQuestions> getFeedquestions() {
	return feedquestions;
}
public void setFeedquestions(Set<FeedBackQuestions> feedquestions) {
	this.feedquestions = feedquestions;
}
public long getObjectiveid() {
	return objectiveid;
}
public void setObjectiveid(long objectiveid) {
	this.objectiveid = objectiveid;
}

}
