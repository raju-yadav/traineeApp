package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.CommonBean;
import model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import service.DepartmentService;
@Component
public class DepartmentValidator {
	@Autowired
	private DepartmentService deptservice;
	private Pattern pattern;
	  private Matcher matcher;
	  private static final String name ="^[a-zA-Z][a-zA-Z\\s]+$";
public void validate(BindingResult errors,CommonBean commonBean) {
	
	 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departmentName", "departmentName.required");
		if(errors.getErrorCount()==0){
			if(commonBean.getDepartmentName().length()>50)
				errors.rejectValue("departmentName", "departmentName.size");
		}
		if(errors.getErrorCount()==0){
			pattern = Pattern.compile(name);
			String deptName=commonBean.getDepartmentName();
			matcher=pattern.matcher(deptName);
			if(!matcher.matches()){
				errors.rejectValue("departmentName", "departmentName.notValid");
			}
		}
		if(errors.getErrorCount()==0){
			String departmentName=commonBean.getDepartmentName();
			Department dept=deptservice.getDept(departmentName);
			 if(dept!=null){
				 errors.rejectValue("departmentName","departmentName.exists");
			 }
		}
}
}
