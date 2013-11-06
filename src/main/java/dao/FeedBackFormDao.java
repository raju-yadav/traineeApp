package dao;



import model.CommonBean;



public interface FeedBackFormDao {

	 void saveOrUpdate(CommonBean commonBean, String today, String name, String trname);

}
