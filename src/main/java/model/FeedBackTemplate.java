package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FeedBackTemplate implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3919225309502119892L;
	private long templateid;
	private String templateName;
	private String version;
	private Date creationDate;
	private Set<FeedBackResults> feedBackResults=new HashSet<FeedBackResults>(0);
	public long getTemplateid() {
		return templateid;
	}
	public void setTemplateid(long templateid) {
		this.templateid = templateid;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Set<FeedBackResults> getFeedBackResults() {
		return feedBackResults;
	}
	public void setFeedBackResults(Set<FeedBackResults> feedBackResults) {
		this.feedBackResults = feedBackResults;
	}
	
	
}
