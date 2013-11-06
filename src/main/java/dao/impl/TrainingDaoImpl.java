package dao.impl;


import java.util.List;

import model.CommonBean;
import model.Department;
import model.Employee;
import model.Group;
import model.Training;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.TrainingDao;
@Repository
public class TrainingDaoImpl extends HibernateDaoSupport implements TrainingDao {

	@Override
	public void saveOrUpdate(CommonBean commonBean) {
		Training training=new Training();
		training.setTrainingName(commonBean.getTrainingName());
		Department department = new Department();
		department.setDeptId(commonBean.getDeptId());
		training.setDepartment(department);
		training.setFromDate(commonBean.getTrFrom());
		training.setTrainingtype(commonBean.getTrainingtype());
		if(commonBean.getTrainerName()!=""){
			Employee employee=new Employee();
			employee.setEmployeeId(commonBean.getTrainerName());
			training.setTrainerId(employee);
		}
		training.setToDate(commonBean.getTrEnd());
		if(commonBean.getGroup()!=0){
			Group group=new Group();
			group.setGroupId(commonBean.getGroup());
			training.setGroup(group);
		}
	
		
		getHibernateTemplate().saveOrUpdate(training);
		
	}
	
	@Override
	public void saveOrUpdate1(CommonBean commonBean,String name) {
		Training training=new Training();
		training.setTrainingId(commonBean.getTrainingId());
		training.setTrainingName(name);
		Department department = new Department();
		department.setDeptId(commonBean.getDeptId());
		training.setDepartment(department);
		training.setFromDate(commonBean.getTrFrom());
		training.setTrainingtype(commonBean.getTrainingtype());
		if(commonBean.getTrainerName()!=""){
			Employee employee=new Employee();
			employee.setEmployeeId(commonBean.getTrainerName());
			training.setTrainerId(employee);
		}
		training.setToDate(commonBean.getTrEnd());
		if(commonBean.getGroup()!=0){
			Group group=new Group();
			group.setGroupId(commonBean.getGroup());
			training.setGroup(group);
		}
		getHibernateTemplate().merge(training);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getData() {
		List<String> list=getHibernateTemplate().findByNamedQuery("tr");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Training getName(String trainingName) {
		List<Training> dept=getHibernateTemplate().findByNamedQuery("name1",trainingName);
		if(dept.size()>0){
			return dept.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Training> getTrainingName() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Training.class);
		
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public Training getTrainingDet(long trainingId) {
		List<Training> training=getHibernateTemplate().findByNamedQuery("trid", trainingId);
		if(training.size()>0){
			return training.get(0);
		}
		return null;
	}

}
