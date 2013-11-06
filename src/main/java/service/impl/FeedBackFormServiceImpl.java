package service.impl;



import model.CommonBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.FeedBackFormService;
import dao.FeedBackFormDao;


@Service
public class FeedBackFormServiceImpl implements FeedBackFormService {
	
	@Autowired
	private FeedBackFormDao feedBackFormDao;

	
	@Override
	public void saveOrUpdate(CommonBean commonBean, String today, String name,
			String trname) {
		feedBackFormDao.saveOrUpdate(commonBean, today, name, trname);
		
	}

	
		
	
	
	
}
