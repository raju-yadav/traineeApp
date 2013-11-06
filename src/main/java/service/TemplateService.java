package service;


import java.util.List;

import model.CommonBean;

public interface TemplateService {

	void saveOrUpdate(CommonBean commonBean);

	void saveOrUpdate1(CommonBean commonBean);

	List<String> getData();

}
