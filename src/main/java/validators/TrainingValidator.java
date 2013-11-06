package validators;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.CommonBean;
import model.Training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import service.TrainingService;

@Component
public class TrainingValidator {
	@Autowired
	private TrainingService trainingService;
	
	private Pattern pattern;
	  private Matcher matcher;
	  private static final String name ="^[a-zA-Z][a-zA-Z\\s]+$";
	public void validate(BindingResult errors, CommonBean commonBean) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingName", "trainingName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingtype", "trainingtype.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trFrom", "trFrom.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trEnd", "trEnd.required");
		if(errors.getErrorCount()==0){
			if(commonBean.getDeptId()==0)
				errors.rejectValue("deptId", "deptId.required");
		}
		if(errors.getErrorCount()==0){
			if(commonBean.getTrainingName().length()>150)
				errors.rejectValue("trainingName", "trainingName.size");
		}
		if(errors.getErrorCount()==0){
			pattern = Pattern.compile(name);
			String trainingName=commonBean.getTrainingName();
			matcher=pattern.matcher(trainingName);
			if(!matcher.matches()){
				//errors.rejectValue("trainingName", "trainingName.notValid");
			}
		}
		if(errors.getErrorCount()==0){
			String trainingName=commonBean.getTrainingName();
			Training dept=trainingService.getName(trainingName);
			 if(dept!=null){
				 errors.rejectValue("trainingName","trainingName.exists");
			 }
		}
		if(errors.getErrorCount()==0){
			Date frmdate=commonBean.getTrFrom();
			Date todate=commonBean.getTrEnd();
			int k=todate.compareTo(frmdate);
			if(k<0){
				errors.rejectValue("trEnd", "trEnd.notValid");
			}
		}
	}
	
	
}
