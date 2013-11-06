package service;
import java.util.List;

import model.CommonBean;
import model.Training;
public interface TrainingService {
public void saveOrUpdate(CommonBean commonBean);

public List<String> getTraining();
public List<Training> getTrainingName();
public Training getName(String trainingName);

public void saveOrUpdate1(CommonBean commonBean,String name);

public Training getTrainingDet(long trainingId);
}
