package service.impl;

import java.util.List;

import model.CommonBean;
import model.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GroupDao;

import service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{
	@Autowired
	private GroupDao groupDao;
	@Override
	public void saveOrUpdate(CommonBean commonBean) {
		groupDao.saveOrUpdate(commonBean);
		
	}
	@Override
	public List<String> getGroup() {
		List<String> gr=groupDao.getData();
		return gr;
	}
	@Override
	public Group getGroup(String groupName) {
		Group gr=groupDao.getGroup(groupName);
		return gr;
	}

}
