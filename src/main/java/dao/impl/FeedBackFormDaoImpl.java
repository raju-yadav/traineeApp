package dao.impl;



import model.FeedBackForm;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.FeedBackFormDao;
import model.CommonBean;
@Repository
public class FeedBackFormDaoImpl extends HibernateDaoSupport implements FeedBackFormDao  {

	@Override
	public void saveOrUpdate(CommonBean commonBean, String today, String name, String trname) {
		
		FeedBackForm feedback = new FeedBackForm();
		feedback.setFeedbackDate(today);
		feedback.setFeedbackTitle(trname);
		feedback.setFaculty(name);
		feedback.setTrObjClearRadio(commonBean.getTrObjClearRadio());
		feedback.setTrObjAchievedRadio(commonBean.getTrObjAchievedRadio());
		feedback.setTrObjContentRadio(commonBean.getTrObjContentRadio());
		feedback.setTrObjRateRadio(commonBean.getTrObjRateRadio());
		feedback.setTrObjReadingRadio(commonBean.getTrObjReadingRadio());
		feedback.setTrObjTopiceRadio(commonBean.getTrObjTopiceRadio());
		feedback.setTrObjJobRadio(commonBean.getTrObjJobRadio());
		feedback.setTrObjPresentedRadio(commonBean.getTrObjPresentedRadio());
		feedback.setTrObjInterestRadio(commonBean.getTrObjInterestRadio());
		feedback.setTrObjLevelRadio(commonBean.getTrObjLevelRadio());
		feedback.setTrObjTrainerRadio(commonBean.getTrObjTrainerRadio());
		feedback.setTrObjTrainrRadio(commonBean.getTrObjTrainrRadio());
		feedback.setTrObjUrsantRadio(commonBean.getTrObjUrsantRadio());
		feedback.setTrObjSessionRadio(commonBean.getTrObjSessionRadio());
		feedback.setTrObjAnsRadio(commonBean.getTrObjAnsRadio());
		feedback.setPerspective(commonBean.getFeedbackPerspective());
		feedback.setSuggestion(commonBean.getFeedbackSuggestion());
		getHibernateTemplate().saveOrUpdate(feedback);
		
		
	}

	
}
