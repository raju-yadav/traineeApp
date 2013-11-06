package validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.CommonBean;
import model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import service.EmployeeService;
@Component
public class EmployeeValidator {
	@Autowired
	EmployeeService empservice;
	
	private Pattern pattern;
	  private Matcher matcher;
	  private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	  private static final String ID_Pattern = "[A-Za-z0-9]{10}";
	  public void validate(BindingResult errors, CommonBean commonBean) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "employeeId.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeName", "employeeName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designationId", "designationId.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailid", "emailid.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reportmanager", "reportmanager.required");
		if(errors.getErrorCount()==0){
			if(commonBean.getDeptId()==0)
				errors.rejectValue("deptId", "deptId.required");
			if(commonBean.getUserTypeId()==0)
				errors.rejectValue("userTypeId", "userTypeId.required");
		}
		if(errors.getErrorCount()==0){
		String empName=commonBean.getEmployeeName();
		if(empName.length()>50){
			errors.rejectValue("employeeName", "employeeName.exceed");
		}
		}
		if(errors.getErrorCount()==0){
			pattern = Pattern.compile(ID_Pattern);
			String empid=commonBean.getEmployeeId();
			matcher=pattern.matcher(empid);
			if(!matcher.matches()){
				errors.rejectValue("employeeId", "employeeId.notValid");
			}
		}
		if(errors.getErrorCount()==0){
			pattern = Pattern.compile(EMAIL_PATTERN);
		String emailid=commonBean.getEmailid();
		 matcher = pattern.matcher(emailid);
		 if(!matcher.matches()){
			 errors.rejectValue("emailid", "emailid.notValid");
		 }
		}
	 if(errors.getErrorCount()==0){
		 String employeeId=commonBean.getEmployeeId();
		 Employee emp=empservice.employeeCheck(employeeId);
		 if(emp!=null){
			 errors.rejectValue("employeeId","employeeId.exists");
		 }
	 }
	 if(errors.getErrorCount()==0){
		 String emailid=commonBean.getEmailid();
		 Employee emp=empservice.emailCheck(emailid);
		 if(emp!=null){
			 errors.rejectValue("emailid", "emailid.exists");
		 }
	 }
	  
	  
	  
	  }
	  }
