package dao;

import java.util.List;

import model.CommonBean;
import model.Training;

public interface TrainingDao {
public void saveOrUpdate(CommonBean commonBean);

public List<String> getData();

public Training getName(String trainingName);

public List<Training> getTrainingName();
public Training getTrainingDet(long trainingId);

void saveOrUpdate1(CommonBean commonBean,String name);
}
