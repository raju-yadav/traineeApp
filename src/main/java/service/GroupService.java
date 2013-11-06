package service;
import java.util.List;

import model.CommonBean;
import model.Group;
public interface GroupService {
public void saveOrUpdate(CommonBean commonBean);

public List<String> getGroup();

public Group getGroup(String groupName);
}
