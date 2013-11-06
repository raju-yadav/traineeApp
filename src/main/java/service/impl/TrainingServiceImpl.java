package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TrainingDao;

import model.CommonBean;
import model.Training;
import service.TrainingService;
@Service
public class TrainingServiceImpl implements TrainingService{
	@Autowired
	private TrainingDao trainingDao;
	@Override
	public void saveOrUpdate(CommonBean commonBean) {
		trainingDao.saveOrUpdate(commonBean);
	}
	@Override
	public List<String> getTraining() {
		List<String> list=trainingDao.getData();
		return list;
	}
	@Override
	public Training getName(String trainingName) {
		Training trName=trainingDao.getName(trainingName);
		return trName;
	}
	@Override
	public List<Training> getTrainingName() {
		
		return trainingDao.getTrainingName();
	}
	@Override
	public void saveOrUpdate1(CommonBean commonBean,String name) {
		trainingDao.saveOrUpdate1(commonBean,name);
		
	}
	@Override
	public Training getTrainingDet(long trainingId) {
		
		return trainingDao.getTrainingDet(trainingId);
	}

}
