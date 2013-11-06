package dao;

import java.util.List;

import model.CommonBean;

public interface TemplateDao {

	void saveOrUpdate(CommonBean commonBean);

	void saveOrUpdate1(CommonBean commonBean);

	List<String> getData();

}
