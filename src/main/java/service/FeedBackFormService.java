package service;



import model.CommonBean;


public interface FeedBackFormService {

	 void saveOrUpdate(CommonBean commonBean, String today, String name, String trname);
	
}
