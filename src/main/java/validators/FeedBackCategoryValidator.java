package validators;

import model.CommonBean;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
@Component
public class FeedBackCategoryValidator {
	public void validate(BindingResult errors,CommonBean commonBean) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trque", "trque.required");
		if(errors.getErrorCount()==0)
		{
		if(commonBean.getObjid()==0)
		{
			errors.rejectValue("objid", "objid.required");
		}
		}
		if(errors.getErrorCount()==0){
			if(commonBean.getTrque().length()>200)
				errors.rejectValue("trque", "trque.size");
		}
	}
}
