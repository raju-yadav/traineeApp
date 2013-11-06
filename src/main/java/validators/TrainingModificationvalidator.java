package validators;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.CommonBean;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

@Component
public class TrainingModificationvalidator {
	
	public void validate(BindingResult errors, CommonBean commonBean) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingId", "trainingId.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingtype", "trainingtype.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trFrom", "trFrom.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trEnd", "trEnd.required");
		if(errors.getErrorCount()==0){
			if(commonBean.getDeptId()==0)
				errors.rejectValue("deptId", "deptId.required");
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