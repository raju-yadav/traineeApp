package validators;

import model.CommonBean;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

@Component
public class CustCategoryValidator {
	public void validate(BindingResult errors,CommonBean commonBean) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trobj", "trobj.required");
		if(errors.getErrorCount()==0){
			if(commonBean.getTrobj().length()>200)
				errors.rejectValue("trobj", "trobj.size");
		}
		
	}
	
}
