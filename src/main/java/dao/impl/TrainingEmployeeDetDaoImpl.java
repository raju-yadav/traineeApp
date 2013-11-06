package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import model.Employee;
import model.Training;
import model.TrainingEmployeeDet;
import dao.TrainingEmployeeDetDao;
@Repository
public class TrainingEmployeeDetDaoImpl extends HibernateDaoSupport implements TrainingEmployeeDetDao{

	@Override
	public void saveorUpdate(Employee emp, Training tr, Date endDate) {
		TrainingEmployeeDet tremp=new TrainingEmployeeDet();
		Employee emp1=new Employee();
		emp1.setEmployeeId(emp.getEmployeeId());
		Training tr1=new Training();
		tr1.setTrainingId(tr.getTrainingId());
		tremp.setEmployee(emp1);
		tremp.setTraining(tr1);
		tremp.setEndDate(endDate);
		getHibernateTemplate().saveOrUpdate(tremp);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public TrainingEmployeeDet getData(Object object) {
		List<TrainingEmployeeDet> trempdet=getHibernateTemplate().findByNamedQuery("userid", object);
		if(trempdet.size()>0){
			return trempdet.get(0);
		}
		return null;
	}

	@Override
	public void saveorUpdate(TrainingEmployeeDet tr) {
		TrainingEmployeeDet tr1=new TrainingEmployeeDet();
		tr1.setId(tr.getId());
		tr1.setEmployee(tr.getEmployee());
		tr1.setTraining(tr.getTraining());
		tr1.setFlag(1);
		tr1.setEndDate(tr.getEndDate());
		getHibernateTemplate().merge(tr1);
		
	}

	

}
