package dao.impl;

import java.util.List;

import model.CommonBean;
import model.FeedBackQuestions;
import model.FeedBackObjectives;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.TemplateDao;
@Repository
public class TemplateDaoImpl extends HibernateDaoSupport implements TemplateDao  {

	@Override
	public void saveOrUpdate(CommonBean commonBean) {
		FeedBackObjectives feed=new FeedBackObjectives();
		feed.setFeedObj(commonBean.getTrobj());
		getHibernateTemplate().saveOrUpdate(feed);
	}

	@Override
	public void saveOrUpdate1(CommonBean commonBean) {
		FeedBackQuestions feed=new FeedBackQuestions();
		FeedBackObjectives obj= new FeedBackObjectives();
		obj.setObjectiveid(commonBean.getObjid());
		feed.setFeedBackObjectives(obj);
		feed.setQuestions(commonBean.getTrque());
		getHibernateTemplate().saveOrUpdate(feed);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getData() {
		DetachedCriteria criteria = DetachedCriteria
		        .forClass(FeedBackObjectives.class);
		List<String> userList = getHibernateTemplate()
		        .findByCriteria(criteria);
		return userList;
	}

}
