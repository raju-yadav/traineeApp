package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TemplateDao;

import model.CommonBean;
import service.TemplateService;
@Service
public class TemplateServiceImpl implements TemplateService{
	@Autowired
	private TemplateDao templateDao;
	@Override
	public void saveOrUpdate(CommonBean commonBean) {
		templateDao.saveOrUpdate(commonBean);
		
	}
	@Override
	public void saveOrUpdate1(CommonBean commonBean) {
		templateDao.saveOrUpdate1(commonBean);
		
	}
	@Override
	public List<String> getData() {
		List<String> obj=templateDao.getData();
		return obj;
	}

}
