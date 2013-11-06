package model;

import java.util.HashSet;
import java.util.Set;

public class Group {
private long groupId;
private String groupName;
private Set<Training> training=new HashSet<Training>(0);

public long getGroupId() {
	return groupId;
}
public void setGroupId(long groupId) {
	this.groupId = groupId;
}
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public Set<Training> getTraining() {
	return training;
}
public void setTraining(Set<Training> training) {
	this.training = training;
}
}
