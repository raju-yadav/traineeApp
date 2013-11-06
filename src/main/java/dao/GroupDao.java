package dao;

import java.util.List;

import model.CommonBean;
import model.Group;

public interface GroupDao {
public void saveOrUpdate(CommonBean commonBean);

public List<String> getData();

public Group getGroup(String groupName);
}
