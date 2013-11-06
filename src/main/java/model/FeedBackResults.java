package model;

public class FeedBackResults implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5012716960663819109L;
	private long feedback_id;
	private FeedBackQuestions question_id;
	private Training template_id;
	private long ratings;
	private long uniqueid;
	private Training training_id;
	private FeedBackTemplate feedBackTemplate;
	public long getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(long feedback_id) {
		this.feedback_id = feedback_id;
	}
	public FeedBackQuestions getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(FeedBackQuestions question_id) {
		this.question_id = question_id;
	}
	public long getRatings() {
		return ratings;
	}
	public void setRatings(long ratings) {
		this.ratings = ratings;
	}
	public long getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(long uniqueid) {
		this.uniqueid = uniqueid;
	}
	public Training getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(Training template_id) {
		this.template_id = template_id;
	}
	public Training getTraining_id() {
		return training_id;
	}
	public void setTraining_id(Training training_id) {
		this.training_id = training_id;
	}
	public FeedBackTemplate getFeedBackTemplate() {
		return feedBackTemplate;
	}
	public void setFeedBackTemplate(FeedBackTemplate feedBackTemplate) {
		this.feedBackTemplate = feedBackTemplate;
	}
}
